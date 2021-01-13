package cn.whl.payutils.test;

import cn.whl.payutils.alipay.vo.create.AliPayCreateIn;
import cn.whl.payutils.alipay.vo.create.AliPayCreateOut;
import cn.whl.payutils.common.PayUtils;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.interfaces.create.CreateOut;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeCreateModel;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import java.math.BigDecimal;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class AliPayController {

    public static void main(String[] args) throws AlipayApiException, Exception {
        //create();
        precreate();
        //wapPay();
        //pagePay();
    }

    public static void pagePay() throws AlipayApiException, Exception {
        AliPayCreateIn in = new AliPayCreateIn();
        in.setServerUrl("https://openapi.alipaydev.com/gateway.do");
        in.setAppId("2021000116691007");
        in.setPrivateKey("MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCKkiY71tCZcmqVcPMC6+69AOrNzDBJ56J9iAaiIONhbhBHG0uINgA2WUZcdkBKRYQ4JLSVwWeAj4r6m5wqBxqfSuSlHVAenpHc7NS3+SHYSvKYYRAJq21uF2mllbO8eDkF1Y48/h3WM+2Kmi4gr83YF739tm3rzOya3SnogzTJ1mxjxo1/69M7veUKlp+FDxkFr5t93YiVMRdIgK8rvlDCTFAeplKjmz///V7zqpKQKvja9i9CI5xi1imHc37/r2mLC1CJ/tT42X6mBKJrMfNiUjSsoRnHqHCr4zFbamZxoIhgxB755PxxB7FUlW3UdBuLGW48ISjh8r0tOhnFHChjAgMBAAECggEATMAUMzKRCVypEiqkPqsE6WR3qRL+cAC/LD5KRkRnDJDUrT2+ASy/w1qBMTdB9qE4UYxrBUNBG6DlvlawEUssAKyPpbBtrvfvHGmEjH2NtGoWojWol2J+0upe1prrGWmRU9zr0naBeiH64Ljy8aHOJnFIBx2jFmbDaiczThhWBbBH0kAucdgVj8GGsAaY9rYYULG2qRiXaqDvSp50j1BoVWW2EACFTOv94kub/HYZ56eE4skMIno0OUUwYjoM3MPEFtF8+Rd26+OAinqeD8dumIc6N/nglgNumikVj2J/+O9mbK2n3ToRtCq7jmEfSKvzQGzF2bAWUQyCsrYTPQnR8QKBgQD6pzyM+SY/aKdV39VInR7pllQkmVAhxwjBtVmVyUIzwY8OD0zmyhmZELuBODQbfkrCDHwE3qzVyuDrBFRNk5OTEZJ4OrDOFyFhtt4f8MSKbIIGa9X/M1ChpxeaHD9nNbxXhprMILG/jJUVTXjRW1839j9xtleqX2blKHFv1nzxyQKBgQCNhtrq/rB6/mPb5QvD1IsYFBcYOloKmVFGWf5kAlvmWNxDyjO+mArx9umxf47Sbhsc8VhtQ5dW5GXDRfO/scTuMCSMJwSC2xKdfOmOz3E1a6mOQ8+psLcZIv8XJCRoTLAZJ7Xl4zjmyxkJhIIUFBEEhzueqgmdpVvaZNHf8Iv+ywKBgBDGVHUSz4560IgcvMdpTIJRfzwbzpMUIO/l1SMDHx0bnRlRyNHBQMlPp1zUiBg28YXfFAW3aVW9iCPyXDn84Gl9SZImS2LfhWpmtKLqmByzelg3q1Cy/Hh1GE1GCrA7lmk9Jur2XS72l5ufXbCVLuAt6L0RePh7/gTkGgNkFWSRAoGAYAsjZ5RduaoHpIPEvynvFvETVyrKTiULxd1uyPnc2e511D9VbEOMMfZpUz6Icv+rwLF8W/IhsyMeeC1xpCaEyUu8kaws4IzBDkVlzreyURl2IIieVb8KErHwQQkS+AELBJcxVwgjZmRv4kidafjQL62CZUNpcSV1tzjyQLHin48CgYB8fqbpfVODmDdaIjJh7yAckFfpVSgrcjO6m9phJd3TnfLGyxRMKMw2Dl0Ty8CM+QuBxhT1zarYoMhVrvEK4giRY3Kzyc679rwxXtmDxNSBlCHFgI+4lp9/OahqH4Xa3t+R8gUHdD1f5hgM1q294F4gV/M3ibBwYLCaMar5dsml2g==");
        in.setAlipayPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlT8S5g6w2RHI1Vicyub5lNTOhH7WZgHWSLF1AZiXvwKowF2x1iYG+xxJqSEE9ogfGj9nHrOWM9YcVO8GFaQSShV/I9wF6gYvO3FJwfhcS6HhSGYy4dTykqUhYcKFLC5QF+g3O8PN/jDCs4d3ZrdUZX0lUyfzXvlvKIuqLJOqeOQc6BE1ZmZx0oQjB4uV61GeP8kBqjzK0ugL5vYtVsl6nb1dpGowGVT+sbmgZCxC7hzu5LMvr9bh16LRzONRO1u6VRvw+of+GItma9/3+ey9jGAPNIqv9Mtl2Dqnv0KkbJmvCDXfrsg4AJQwPkO/T0qi2ZI82lIUYcGuvUGpM6MEXQIDAQAB");
        in.setNotifyUrl("");
        in.setReturnUrl("https://localhost:8080/canteen/customer/invest.html");

        in.setOutTradeNo("CS_PAGE" + new Random().nextInt(1000000));
        in.setSubject("测试001");
        in.setTotalAmount(BigDecimal.TEN);
        in.setBody("ceshi0001");
        in.setTimeoutExpress("1h");
        in.setProductCode("FAST_INSTANT_TRADE_PAY");

        in.setPayType(PayType.PAGE);
        CreateOut create = PayUtils.create(in);

        System.out.println(create.getPlatform()); 
        System.out.println(create.getPayType());
        AliPayCreateOut out = (AliPayCreateOut) create;
        System.out.println(out.getForm());
    }

    public static void wapPay() throws AlipayApiException, Exception {
        AliPayCreateIn in = new AliPayCreateIn();
        in.setServerUrl("https://openapi.alipaydev.com/gateway.do");
        in.setAppId("2021000116691007");
        in.setPrivateKey("MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCKkiY71tCZcmqVcPMC6+69AOrNzDBJ56J9iAaiIONhbhBHG0uINgA2WUZcdkBKRYQ4JLSVwWeAj4r6m5wqBxqfSuSlHVAenpHc7NS3+SHYSvKYYRAJq21uF2mllbO8eDkF1Y48/h3WM+2Kmi4gr83YF739tm3rzOya3SnogzTJ1mxjxo1/69M7veUKlp+FDxkFr5t93YiVMRdIgK8rvlDCTFAeplKjmz///V7zqpKQKvja9i9CI5xi1imHc37/r2mLC1CJ/tT42X6mBKJrMfNiUjSsoRnHqHCr4zFbamZxoIhgxB755PxxB7FUlW3UdBuLGW48ISjh8r0tOhnFHChjAgMBAAECggEATMAUMzKRCVypEiqkPqsE6WR3qRL+cAC/LD5KRkRnDJDUrT2+ASy/w1qBMTdB9qE4UYxrBUNBG6DlvlawEUssAKyPpbBtrvfvHGmEjH2NtGoWojWol2J+0upe1prrGWmRU9zr0naBeiH64Ljy8aHOJnFIBx2jFmbDaiczThhWBbBH0kAucdgVj8GGsAaY9rYYULG2qRiXaqDvSp50j1BoVWW2EACFTOv94kub/HYZ56eE4skMIno0OUUwYjoM3MPEFtF8+Rd26+OAinqeD8dumIc6N/nglgNumikVj2J/+O9mbK2n3ToRtCq7jmEfSKvzQGzF2bAWUQyCsrYTPQnR8QKBgQD6pzyM+SY/aKdV39VInR7pllQkmVAhxwjBtVmVyUIzwY8OD0zmyhmZELuBODQbfkrCDHwE3qzVyuDrBFRNk5OTEZJ4OrDOFyFhtt4f8MSKbIIGa9X/M1ChpxeaHD9nNbxXhprMILG/jJUVTXjRW1839j9xtleqX2blKHFv1nzxyQKBgQCNhtrq/rB6/mPb5QvD1IsYFBcYOloKmVFGWf5kAlvmWNxDyjO+mArx9umxf47Sbhsc8VhtQ5dW5GXDRfO/scTuMCSMJwSC2xKdfOmOz3E1a6mOQ8+psLcZIv8XJCRoTLAZJ7Xl4zjmyxkJhIIUFBEEhzueqgmdpVvaZNHf8Iv+ywKBgBDGVHUSz4560IgcvMdpTIJRfzwbzpMUIO/l1SMDHx0bnRlRyNHBQMlPp1zUiBg28YXfFAW3aVW9iCPyXDn84Gl9SZImS2LfhWpmtKLqmByzelg3q1Cy/Hh1GE1GCrA7lmk9Jur2XS72l5ufXbCVLuAt6L0RePh7/gTkGgNkFWSRAoGAYAsjZ5RduaoHpIPEvynvFvETVyrKTiULxd1uyPnc2e511D9VbEOMMfZpUz6Icv+rwLF8W/IhsyMeeC1xpCaEyUu8kaws4IzBDkVlzreyURl2IIieVb8KErHwQQkS+AELBJcxVwgjZmRv4kidafjQL62CZUNpcSV1tzjyQLHin48CgYB8fqbpfVODmDdaIjJh7yAckFfpVSgrcjO6m9phJd3TnfLGyxRMKMw2Dl0Ty8CM+QuBxhT1zarYoMhVrvEK4giRY3Kzyc679rwxXtmDxNSBlCHFgI+4lp9/OahqH4Xa3t+R8gUHdD1f5hgM1q294F4gV/M3ibBwYLCaMar5dsml2g==");
        in.setAlipayPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlT8S5g6w2RHI1Vicyub5lNTOhH7WZgHWSLF1AZiXvwKowF2x1iYG+xxJqSEE9ogfGj9nHrOWM9YcVO8GFaQSShV/I9wF6gYvO3FJwfhcS6HhSGYy4dTykqUhYcKFLC5QF+g3O8PN/jDCs4d3ZrdUZX0lUyfzXvlvKIuqLJOqeOQc6BE1ZmZx0oQjB4uV61GeP8kBqjzK0ugL5vYtVsl6nb1dpGowGVT+sbmgZCxC7hzu5LMvr9bh16LRzONRO1u6VRvw+of+GItma9/3+ey9jGAPNIqv9Mtl2Dqnv0KkbJmvCDXfrsg4AJQwPkO/T0qi2ZI82lIUYcGuvUGpM6MEXQIDAQAB");
        in.setNotifyUrl("");
        in.setReturnUrl("https://localhost:8080/canteen/customer/invest.html");

        in.setOutTradeNo("CS_WAP" + new Random().nextInt(1000000));
        in.setSubject("测试002");
        in.setTotalAmount(BigDecimal.TEN);
        in.setBody("ceshi0002");
        in.setTimeoutExpress("1h");
        in.setProductCode("QUICK_WAP_PAY");

        in.setPayType(PayType.WAP);
        CreateOut create = PayUtils.create(in);

        System.out.println(create.getPlatform());
        System.out.println(create.getPayType());
        AliPayCreateOut out = (AliPayCreateOut) create;
        System.out.println(out.getForm());
    }

    public static void precreate() throws AlipayApiException, Exception {
        AliPayCreateIn in = new AliPayCreateIn();
        in.setServerUrl("https://openapi.alipaydev.com/gateway.do");
        in.setAppId("2021000116691007");
        in.setPrivateKey("MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCKkiY71tCZcmqVcPMC6+69AOrNzDBJ56J9iAaiIONhbhBHG0uINgA2WUZcdkBKRYQ4JLSVwWeAj4r6m5wqBxqfSuSlHVAenpHc7NS3+SHYSvKYYRAJq21uF2mllbO8eDkF1Y48/h3WM+2Kmi4gr83YF739tm3rzOya3SnogzTJ1mxjxo1/69M7veUKlp+FDxkFr5t93YiVMRdIgK8rvlDCTFAeplKjmz///V7zqpKQKvja9i9CI5xi1imHc37/r2mLC1CJ/tT42X6mBKJrMfNiUjSsoRnHqHCr4zFbamZxoIhgxB755PxxB7FUlW3UdBuLGW48ISjh8r0tOhnFHChjAgMBAAECggEATMAUMzKRCVypEiqkPqsE6WR3qRL+cAC/LD5KRkRnDJDUrT2+ASy/w1qBMTdB9qE4UYxrBUNBG6DlvlawEUssAKyPpbBtrvfvHGmEjH2NtGoWojWol2J+0upe1prrGWmRU9zr0naBeiH64Ljy8aHOJnFIBx2jFmbDaiczThhWBbBH0kAucdgVj8GGsAaY9rYYULG2qRiXaqDvSp50j1BoVWW2EACFTOv94kub/HYZ56eE4skMIno0OUUwYjoM3MPEFtF8+Rd26+OAinqeD8dumIc6N/nglgNumikVj2J/+O9mbK2n3ToRtCq7jmEfSKvzQGzF2bAWUQyCsrYTPQnR8QKBgQD6pzyM+SY/aKdV39VInR7pllQkmVAhxwjBtVmVyUIzwY8OD0zmyhmZELuBODQbfkrCDHwE3qzVyuDrBFRNk5OTEZJ4OrDOFyFhtt4f8MSKbIIGa9X/M1ChpxeaHD9nNbxXhprMILG/jJUVTXjRW1839j9xtleqX2blKHFv1nzxyQKBgQCNhtrq/rB6/mPb5QvD1IsYFBcYOloKmVFGWf5kAlvmWNxDyjO+mArx9umxf47Sbhsc8VhtQ5dW5GXDRfO/scTuMCSMJwSC2xKdfOmOz3E1a6mOQ8+psLcZIv8XJCRoTLAZJ7Xl4zjmyxkJhIIUFBEEhzueqgmdpVvaZNHf8Iv+ywKBgBDGVHUSz4560IgcvMdpTIJRfzwbzpMUIO/l1SMDHx0bnRlRyNHBQMlPp1zUiBg28YXfFAW3aVW9iCPyXDn84Gl9SZImS2LfhWpmtKLqmByzelg3q1Cy/Hh1GE1GCrA7lmk9Jur2XS72l5ufXbCVLuAt6L0RePh7/gTkGgNkFWSRAoGAYAsjZ5RduaoHpIPEvynvFvETVyrKTiULxd1uyPnc2e511D9VbEOMMfZpUz6Icv+rwLF8W/IhsyMeeC1xpCaEyUu8kaws4IzBDkVlzreyURl2IIieVb8KErHwQQkS+AELBJcxVwgjZmRv4kidafjQL62CZUNpcSV1tzjyQLHin48CgYB8fqbpfVODmDdaIjJh7yAckFfpVSgrcjO6m9phJd3TnfLGyxRMKMw2Dl0Ty8CM+QuBxhT1zarYoMhVrvEK4giRY3Kzyc679rwxXtmDxNSBlCHFgI+4lp9/OahqH4Xa3t+R8gUHdD1f5hgM1q294F4gV/M3ibBwYLCaMar5dsml2g==");
        in.setAlipayPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlT8S5g6w2RHI1Vicyub5lNTOhH7WZgHWSLF1AZiXvwKowF2x1iYG+xxJqSEE9ogfGj9nHrOWM9YcVO8GFaQSShV/I9wF6gYvO3FJwfhcS6HhSGYy4dTykqUhYcKFLC5QF+g3O8PN/jDCs4d3ZrdUZX0lUyfzXvlvKIuqLJOqeOQc6BE1ZmZx0oQjB4uV61GeP8kBqjzK0ugL5vYtVsl6nb1dpGowGVT+sbmgZCxC7hzu5LMvr9bh16LRzONRO1u6VRvw+of+GItma9/3+ey9jGAPNIqv9Mtl2Dqnv0KkbJmvCDXfrsg4AJQwPkO/T0qi2ZI82lIUYcGuvUGpM6MEXQIDAQAB");
        in.setNotifyUrl("");
        in.setReturnUrl("https://localhost:8080/canteen/customer/invest.html");

        in.setOutTradeNo("CS_PRE" + new Random().nextInt(1000000));
        in.setSubject("测试003");
        in.setTotalAmount(BigDecimal.TEN);
        in.setBody("ceshi0003");
        in.setTimeoutExpress("1h");
        in.setProductCode("FACE_TO_FACE_PAYMENT");
        in.setSellerId("2088621955065049");

        in.setPayType(PayType.PRE);
        CreateOut create = PayUtils.create(in);

        System.out.println(create.getPlatform());
        System.out.println(create.getPayType());
        AliPayCreateOut out = (AliPayCreateOut) create;
        System.out.println(out.getCode());
        System.out.println(out.getMsg());
        System.out.println(out.getSubMsg());
        System.out.println(out.getOutTradeNo());
        System.out.println(out.getResultJson());
        
    }

    public static void create() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(
                "https://openapi.alipaydev.com/gateway.do",
                "2021000116691007",
                "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCKkiY71tCZcmqVcPMC6+69AOrNzDBJ56J9iAaiIONhbhBHG0uINgA2WUZcdkBKRYQ4JLSVwWeAj4r6m5wqBxqfSuSlHVAenpHc7NS3+SHYSvKYYRAJq21uF2mllbO8eDkF1Y48/h3WM+2Kmi4gr83YF739tm3rzOya3SnogzTJ1mxjxo1/69M7veUKlp+FDxkFr5t93YiVMRdIgK8rvlDCTFAeplKjmz///V7zqpKQKvja9i9CI5xi1imHc37/r2mLC1CJ/tT42X6mBKJrMfNiUjSsoRnHqHCr4zFbamZxoIhgxB755PxxB7FUlW3UdBuLGW48ISjh8r0tOhnFHChjAgMBAAECggEATMAUMzKRCVypEiqkPqsE6WR3qRL+cAC/LD5KRkRnDJDUrT2+ASy/w1qBMTdB9qE4UYxrBUNBG6DlvlawEUssAKyPpbBtrvfvHGmEjH2NtGoWojWol2J+0upe1prrGWmRU9zr0naBeiH64Ljy8aHOJnFIBx2jFmbDaiczThhWBbBH0kAucdgVj8GGsAaY9rYYULG2qRiXaqDvSp50j1BoVWW2EACFTOv94kub/HYZ56eE4skMIno0OUUwYjoM3MPEFtF8+Rd26+OAinqeD8dumIc6N/nglgNumikVj2J/+O9mbK2n3ToRtCq7jmEfSKvzQGzF2bAWUQyCsrYTPQnR8QKBgQD6pzyM+SY/aKdV39VInR7pllQkmVAhxwjBtVmVyUIzwY8OD0zmyhmZELuBODQbfkrCDHwE3qzVyuDrBFRNk5OTEZJ4OrDOFyFhtt4f8MSKbIIGa9X/M1ChpxeaHD9nNbxXhprMILG/jJUVTXjRW1839j9xtleqX2blKHFv1nzxyQKBgQCNhtrq/rB6/mPb5QvD1IsYFBcYOloKmVFGWf5kAlvmWNxDyjO+mArx9umxf47Sbhsc8VhtQ5dW5GXDRfO/scTuMCSMJwSC2xKdfOmOz3E1a6mOQ8+psLcZIv8XJCRoTLAZJ7Xl4zjmyxkJhIIUFBEEhzueqgmdpVvaZNHf8Iv+ywKBgBDGVHUSz4560IgcvMdpTIJRfzwbzpMUIO/l1SMDHx0bnRlRyNHBQMlPp1zUiBg28YXfFAW3aVW9iCPyXDn84Gl9SZImS2LfhWpmtKLqmByzelg3q1Cy/Hh1GE1GCrA7lmk9Jur2XS72l5ufXbCVLuAt6L0RePh7/gTkGgNkFWSRAoGAYAsjZ5RduaoHpIPEvynvFvETVyrKTiULxd1uyPnc2e511D9VbEOMMfZpUz6Icv+rwLF8W/IhsyMeeC1xpCaEyUu8kaws4IzBDkVlzreyURl2IIieVb8KErHwQQkS+AELBJcxVwgjZmRv4kidafjQL62CZUNpcSV1tzjyQLHin48CgYB8fqbpfVODmDdaIjJh7yAckFfpVSgrcjO6m9phJd3TnfLGyxRMKMw2Dl0Ty8CM+QuBxhT1zarYoMhVrvEK4giRY3Kzyc679rwxXtmDxNSBlCHFgI+4lp9/OahqH4Xa3t+R8gUHdD1f5hgM1q294F4gV/M3ibBwYLCaMar5dsml2g==",
                "json",
                "UTF-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlT8S5g6w2RHI1Vicyub5lNTOhH7WZgHWSLF1AZiXvwKowF2x1iYG+xxJqSEE9ogfGj9nHrOWM9YcVO8GFaQSShV/I9wF6gYvO3FJwfhcS6HhSGYy4dTykqUhYcKFLC5QF+g3O8PN/jDCs4d3ZrdUZX0lUyfzXvlvKIuqLJOqeOQc6BE1ZmZx0oQjB4uV61GeP8kBqjzK0ugL5vYtVsl6nb1dpGowGVT+sbmgZCxC7hzu5LMvr9bh16LRzONRO1u6VRvw+of+GItma9/3+ey9jGAPNIqv9Mtl2Dqnv0KkbJmvCDXfrsg4AJQwPkO/T0qi2ZI82lIUYcGuvUGpM6MEXQIDAQAB",
                "RSA2");
        AlipayTradeCreateRequest alipay_request = new AlipayTradeCreateRequest();

        // 封装请求支付信息
        AlipayTradeCreateModel model = new AlipayTradeCreateModel();
        model.setOutTradeNo("CS0002");
        model.setSubject("测试001");
        model.setTotalAmount("0.11");
        model.setBody("ceshi0001");
        model.setTimeoutExpress("1c");
        model.setProductCode("FACE_TO_FACE_PAYMENT");
        model.setSellerId("2088621955065049");
        model.setBuyerId("2088621955065049");
        //model.setBusinessParams("111");
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl("");
        // 设置同步地址
        alipay_request.setReturnUrl("");

        AlipayTradeCreateResponse response = alipayClient.execute(alipay_request);
        System.out.println(response.isSuccess());
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        System.out.println(response.getSubMsg());
        System.out.println(response.getOutTradeNo());
        //System.out.println(response.getTradeNo());
        //System.out.println(response.getTotalAmount());
        //System.out.println(response.getSellerId());
        //System.out.println(response.getMerchantOrderNo());
        System.out.println(response.getBody());
    }
}
