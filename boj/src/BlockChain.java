import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class BlockChain {
	static BigInteger nonce;
	static ArrayList<Block> blockList = new ArrayList<Block>();

	public static void main(String[] args) throws Exception {
		Block block = new Block(BigInteger.ZERO, "Genesis Block", "", sha256("Genesis Block"));
		blockList.add(block);
		System.out.println(block);
		chainning("2nd");
		chainning("3rd");
	}

	private static void chainning(String data) throws NoSuchAlgorithmException {
		Block prevBlock = blockList.get(blockList.size() - 1);
		nonce = BigInteger.ZERO;
		while (true) {
			String hash = sha256(nonce.toString() + data);
			if (hash.substring(0, 5).equals("00000")) {
				Block block = new Block(nonce, data, prevBlock.hash, hash);
				blockList.add(block);
				System.out.println(block);
				break;
			}
			nonce = nonce.add(BigInteger.ONE);
		}
	}

	private static String sha256(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());

		return bytesToHex1(md.digest());
	}

	private static String bytesToHex1(byte[] bytes) {

		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}

	static class Block {
		private BigInteger nonce;
		private String data;
		private String hash;
		private String previousHash;
		
		public Block(BigInteger nonce, String data, String previousHash, String hash) {
			this.nonce = nonce;
			this.data = data;
			this.previousHash = previousHash;
			this.hash = hash;
		}

		public BigInteger getNonce() {
			return nonce;
		}

		public void setNonce(BigInteger nonce) {
			this.nonce = nonce;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getHash() {
			return hash;
		}

		public void setHash(String hash) {
			this.hash = hash;
		}

		public String getPreviousHash() {
			return previousHash;
		}

		public void setPreviousHash(String previousHash) {
			this.previousHash = previousHash;
		}
		
		@Override
		public String toString() {
			return "nonce : " + nonce + "\ndata : " + data + "\npreviousHash : " + previousHash + "\nhash : " + hash + "\n";
		}
	}

}
