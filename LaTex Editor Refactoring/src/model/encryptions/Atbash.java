package model.encryptions;

public class Atbash implements Encryption
{
	@Override
	public String encrypt(String plaintext)
	{
		String ciphertext = "";
        for(char c : plaintext.toCharArray())
        {
            if(Character.isLetter(c) && Character.isLowerCase(c))
            {
                ciphertext += (char) ('a' + ('z' - c));
            }
            else if(Character.isLetter(c) && Character.isUpperCase(c)) 
            {
            	ciphertext += (char) ('A' + ('Z' - c));
            }
            else
            {
                ciphertext += c;
            }
        }
		return ciphertext;
	}

	@Override
	public String decrypt(String ciphertext) 
	{
		String plaintext = "";
		for(char c : ciphertext.toCharArray())
		{
		    if(Character.isLetter(c))
		    {
		        plaintext += (char) ('z' + ('a' - c));
		    }
		    else
		    {
		        plaintext += c;
		    }
		}
		return plaintext;
	}
}
