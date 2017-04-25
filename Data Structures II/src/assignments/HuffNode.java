import support.BSTNode;

public class HuffNode extends BSTNode<String> implements Comparable<HuffNode> {
	private String value;
	private double f;

	public HuffNode(String val, double freq) {
		super(val);
		value = val;
		f = freq;
	}
	
	public String getValue() {
		return value;
	}
	
	public double getFreq() {
		return f;
	}

	public int compareTo(HuffNode node) {
		if (f >= node.getFreq())
			return 1;
		else
			return -1;
	}
}