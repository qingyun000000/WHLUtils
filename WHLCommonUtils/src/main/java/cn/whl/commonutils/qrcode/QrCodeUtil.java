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
        String str = "";
        try {
            QRCodeWriter qRCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qRCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
            //ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            //MatrixToImageWriter.writeToStream(bitMatrix, "PNG",outputStream);
            //str = outputStream.toString();
            File filePath = new File(path + "/");
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            FileOutputStream out = new FileOutputStream(path + "/" + name);
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG",out);
            str = out.toString();
        }catch (IOException | WriterException ex) {
            Logger.getLogger(QrCodeUtil.class.getName()).log(Level.SEVERE, null, ex);
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        
        result.setSuccess(true);
        result.setMessage(str);
        
        return result;
    }
    
}
