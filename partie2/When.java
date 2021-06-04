package partie2;

public class When {

	private String start;
	private int stop;
	public When(int stp) {
		start = "now";
		stop =stp;
	}
	@Override
	public String toString() {
		return "<" + start + ">...<" + stop + "min>";
	}
	
	
}
