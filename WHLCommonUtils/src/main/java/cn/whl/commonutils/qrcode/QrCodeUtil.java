package cn.whl.commonutils.qrcode;

import cn.whl.commonutils.Result;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
        
        BitMatrix bitMatrix = null;
        try{
            QRCodeWriter qRCodeWriter = new QRCodeWriter();
            bitMatrix = qRCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
            File filePath = new File(path + "/");
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
        }catch(WriterException ex){
            Logger.getLogger(QrCodeUtil.class.getName()).log(Level.SEVERE, null, ex);
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        
        try(FileOutputStream out = new FileOutputStream(path + "/" + name)) {
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", out);
            out.flush();
        } catch (IOException ex) {
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
    
    /**
     * 二维码解码
     * @param path
     * @return 
     */
    public static Result encode(String path) {
        Result result = new Result();
        try{
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            QRCodeReader codeReader = new QRCodeReader();
            com.google.zxing.Result decode = codeReader.decode(bitmap);
            
            result.setSuccess(true);
            result.setData(decode.getText());
        }catch(ChecksumException | FormatException | IOException | NotFoundException ex){
            Logger.getLogger(QrCodeUtil.class.getName()).log(Level.SEVERE, null, ex);
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }
    
    
}
