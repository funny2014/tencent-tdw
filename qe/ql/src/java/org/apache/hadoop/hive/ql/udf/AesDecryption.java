package org.apache.hadoop.hive.ql.udf;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.exec.description;
import org.apache.hadoop.io.Text;

import sun.misc.BASE64Decoder;

//UDF�������ڵ��������У�����һ��������
//�û�����Ҫ�̳�UDF���ұ�������ʵ��һ��evalute�������÷���������UDF��
//����Hive�����û���UDF�Ƿ�ӵ��һ��evalute����

@description(name = "AesDecryption", value = "_FUNC_(str) - returns the AesDecryption of str", extended = "Returns NULL if the argument is NULL.\n"
    + "Example:\n"
    + "  > SELECT _FUNC_('abc') FROM src LIMIT 1;\n"
    + "  ''")
public class AesDecryption extends UDF {
  private Text result = new Text();
  private static byte[] DefaultAesKey = "Aefse0a\0\0\0\0\0\0\0\0\0".getBytes();
  private static IvParameterSpec iv = new IvParameterSpec(DefaultAesKey);
  private static SecretKeySpec skeySpec = new SecretKeySpec(DefaultAesKey, "AES");

  // ����
    public static String Decrypt(String sSrc, byte[] raw){
        try {
          Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = (new BASE64Decoder()).decodeBuffer(sSrc);//����base64����
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
  // �Զ��巽��
  public Text evaluate(Text str) {
    if (str == null)
      return null;

    String tmp=Decrypt(str.toString(), DefaultAesKey);
    if (tmp == null)
      return null;
    else
      result.set(tmp);
    return result;
    
  }
}
