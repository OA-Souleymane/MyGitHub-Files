package partie2;

public class When {

	private String start;
	private int stop;
	
	public When() {
		start = "now";
		stop = 0;
	}
	
	public When(String strt, int stp) {
		start = strt;
		stop =stp;
	}
	@Override
	public String toString() {
		return "<" + start + ">...<" + stop + "sec>";
	}
	
	public String getStart() {
		return start;
	}
	public int getStop() {
		return stop;
	}
	
	public void setStart(String strt) {
		start = strt;
	}
	public void setStop(int stp) {
		stop = stp;
	}
}
