package cn.whl.commonutils.qrcode;

import cn.whl.commonutils.Result;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 二维码工具
 * @author wuhailong
 */
public class QrCodeUtil {
    
    /**
     * 获取二维码图片
     * @param content
     * @param width
     * @param height
     * @param path
     * @param name
     * @return
     */
    public static Result getQrCodeImage(String content, int width, int height, String path, String name){
        Result result = new Result();
        try {
            QRCodeWriter qRCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qRCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
            File filePath = new File(path + "/");
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            FileOutputStream out = new FileOutputStream(path + "/" + name);
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", out);
            out.flush();
            out.close();
        } catch (IOException | WriterException ex) {
            Logger.getLogger(QrCodeUtil.class.getName()).log(Level.SEVERE, null, ex);
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        
        result.setSuccess(true);
        result.setMessage(path + "/" + name);
        
        return result;
    }
    
    /**
     * 获取二维码
     * @param content
     * @param width
     * @param height
     * @param path
     * @param name
     * @return 字节数组
     */
    public static Result getQrCode(String content, int width, int height, String path, String name){
        Result result = new Result();
        getQrCodeImage(content, width, height, path, name);
        byte[] bytes = null;
        try {
            QRCodeWriter qRCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qRCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                MatrixToImageWriter.writeToStream(bitMatrix, "PNG",outputStream);
                bytes = outputStream.toByteArray();
            }
        }catch (IOException | WriterException ex) {
            Logger.getLogger(QrCodeUtil.class.getName()).log(Level.SEVERE, null, ex);
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        
        result.setSuccess(true);
        result.setData(bytes);
        
        return result;
    }
    
    /**
     * 获取二维码
     * @param content
     * @param width
     * @param height
     * @return 字节数组
     */
    public static Result getQrCode(String content, int width, int height){
        Result result = new Result();
        byte[] bytes = null;
        try {
            QRCodeWriter qRCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qRCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                MatrixToImageWriter.writeToStream(bitMatrix, "PNG",outputStream);
                bytes = outputStream.toByteArray();
            }
        }catch (IOException | WriterException ex) {
            Logger.getLogger(QrCodeUtil.class.getName()).log(Level.SEVERE, null, ex);
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        
        result.setSuccess(true);
        result.setData(bytes);
        
        return result;
    }
    
    public static void main(String[] args){
        Result qrCode = getQrCode("11111", 600, 600, "/usr/zy/qr", "测试" + new Date().getTime());
        byte[] qr = (byte[])(qrCode.getData());
        System.out.println(Arrays.toString(qr));
    } 
    
}
