package model.encryptions;

public interface Encryption 
{
	public String encrypt(String plaintext);
	public String decrypt(String ciphertext);
}
