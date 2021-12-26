package co.bambbang.board.vo;

import java.sql.Date;

public class BoardVO {
	private int bId;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private Date bDate; //date type => 두개 있음 대부분 javautil 그런데 우리는 java sql date 쓸거임
	private int bHit;
	
	public BoardVO() {
		super();
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	@Override
	public String toString() {
		return "BoardVO [bId=" + bId + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bWriter=" + bWriter
				+ ", bDate=" + bDate + ", bHit=" + bHit + "]";
	}
	
	
	
	
	
}
