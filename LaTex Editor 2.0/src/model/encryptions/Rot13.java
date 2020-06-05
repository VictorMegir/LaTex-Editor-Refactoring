package model.encryptions;

public class Rot13 implements Encryption
{
	@Override
	public String encrypt(String plaintext) 
	{
		String ciphertext;
		int len = plaintext.length();
		char[] updatedArr = new char[len + 1];
		    
        for (int i = 0; i < plaintext.length(); i++)
        {
            char c = plaintext.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            updatedArr[i] = c;
        }
        ciphertext = new String(updatedArr);
        return ciphertext;
	}

	@Override
	public String decrypt(String ciphertext)
	{
		return encrypt(ciphertext);
	}
}