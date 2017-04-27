import support.BSTNode;

public class HuffNode extends BSTNode<String> implements Comparable<HuffNode> {
	private String value;
	private double f;
	/**
	 * Constructor for a HuffNode
	 * @param val the name of the node
	 * @param freq the frequency of the node
	 */
	public HuffNode(String val, double freq) {
		super(val);
		value = val;
		f = freq;
	}
	/**
	 * gets the name of the node
	 * @return the name of the node
	 */
	public String getValue() {
		return value;
	}
	/**
	 * gets the frequency of the node
	 * @return the frequency of the node
	 */
	public double getFreq() {
		return f;
	}
	/**
	 * Overrides Comparable's compareTo, 1 if greater or equal, -1 if less
	 */
	public int compareTo(HuffNode node) {
		if (f >= node.getFreq())
			return 1;
		else
			return -1;
	}
}
