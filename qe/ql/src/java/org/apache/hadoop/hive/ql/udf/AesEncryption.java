package org.apache.hadoop.hive.ql.udf;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.exec.description;
import org.apache.hadoop.io.Text;

import sun.misc.BASE64Encoder;


//UDF�������ڵ��������У�����һ��������
//�û�����Ҫ�̳�UDF���ұ�������ʵ��һ��evalute�������÷���������UDF��
//����Hive�����û���UDF�Ƿ�ӵ��һ��evalute����

@description(name = "AesEncryption", value = "_FUNC_(str) - returns the AesEncryption of str", extended = "Returns NULL if the argument is NULL.\n"
    + "Example:\n"
    + "  > SELECT _FUNC_('abc') FROM src LIMIT 1;\n"
    + "  ''")
public class AesEncryption extends UDF {
  private Text result = new Text();
  private static byte[] DefaultAesKey = "Aefse0a\0\0\0\0\0\0\0\0\0".getBytes();
  private static IvParameterSpec iv = new IvParameterSpec(DefaultAesKey);// ʹ��CBCģʽ����Ҫһ������iv�������Ӽ����㷨��ǿ��
  private static SecretKeySpec skeySpec = new SecretKeySpec(DefaultAesKey, "AES");

  // ����
  public static String Encrypt(String sSrc, byte[] raw) {
    /*
     * if (sKey == null) { System.out.print("KeyΪ��null"); return null; } //
     * �ж�Key�Ƿ�Ϊ16λ if (sKey.length() != 16) {
     * System.out.print("Key���Ȳ���16λ"); return null; } byte[] raw =
     * sKey.getBytes();
     */
    try {
      
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "�㷨/ģʽ/���뷽ʽ"
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
      byte[] encrypted = cipher.doFinal(sSrc.getBytes());
      return new BASE64Encoder().encode(encrypted);// �˴�ʹ��BASE64��ת�빦�ܣ�ͬʱ����2�μ��ܵ����á�
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchPaddingException e) {
      e.printStackTrace();
    } catch (InvalidKeyException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    } catch (BadPaddingException e) {
      e.printStackTrace();
    } catch (InvalidAlgorithmParameterException e){
      e.printStackTrace();
    }
    return null;

  }

  // �Զ��巽��
  public Text evaluate(Text str) {
    if (str == null)
      return null;
    String tmp = Encrypt(str.toString(), DefaultAesKey);

    if (tmp == null)
      return null;
    else
      result.set(tmp);
    return result;
  }
  
  public Text evaluate(Text str, Text key) {
    if (str == null)
      return null;
    String tmp = Encrypt(str.toString(), key.getBytes());

    if (tmp == null)
      return null;
    else
      result.set(tmp);
    return result;
  }
}
