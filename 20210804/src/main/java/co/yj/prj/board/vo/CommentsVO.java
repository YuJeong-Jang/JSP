package co.yj.prj.board.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsVO {
	private int sNo;
	private int cNo;
	private String cName;
	private String cSubject;
	private Date cDate;

}
