package co.yj.Lms.sns.vo;

import java.sql.Date;

public class SnsVO extends CommentsVO {	//댓글vo를 상속받음으로서 연결됨 어느 테이블이 상속인지 잘 보고 상속시키면 댓글기능 사용가능
	//VO객체도 클래스이기 때문에 상속가능
	private int sNo;
	private String sWriter;
	private Date sDate;
	private String sTitle;
	private String sContents;
	private int sAno;

	public SnsVO() {
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getsWriter() {
		return sWriter;
	}

	public void setsWriter(String sWriter) {
		this.sWriter = sWriter;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsContents() {
		return sContents;
	}

	public void setsContents(String sContents) {
		this.sContents = sContents;
	}

	public int getsAno() {
		return sAno;
	}

	public void setsAno(int sAno) {
		this.sAno = sAno;
	}
}
