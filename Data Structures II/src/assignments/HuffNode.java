package assignments;

public class HuffNode implements Comparable<HuffNode> {
	private String value;
	private double f;

	public HuffNode(String val, double freq) {
		value = val;
		f = freq;
	}
	
	public String getValue() {
		return value;
	}
	
	public double getFreq() {
		return f;
	}

	@Override
	public int compareTo(HuffNode node) {
		if (f > node.getFreq())
			return 1;
		else if (f == node.getFreq())
			return 0;
		else
			return -1;
	}
}
