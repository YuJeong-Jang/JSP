package co.yj.prj.comm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DownLoadFile {
	private String path; // 파일이 실제 들어있는 물리적 공간 주소
	private String orgFileName; // 원본 파일명
	private String downFileName; // 실제 다운로드 될 파일명

	public DownLoadFile(String path, String orgFileName, String downFileName) {
		this.path = path;
		this.orgFileName = orgFileName;
		this.downFileName = downFileName;
	}

	public boolean isFileDown() { // 성공하면 false, 실패하면 true
		boolean bool = true;
		File file = new File(path + File.separator + downFileName);
		try {
			FileInputStream in = new FileInputStream(file);
			FileOutputStream out = new FileOutputStream("D://downLoad//" + orgFileName);
			// 같은 이름을 다운로드 하면 (img1, img2) 그냥 덮어 써버림.
			// db에 저장될때만 구분을 위해 img1, img2로 구분된거지 실제로는 동일 파일명임
			byte b[] = new byte[4096];
			int data = 0;
			while ((data = in.read(b, 0, b.length)) != -1) {
				out.write(b, 0, data);
			}
			out.flush();
			in.close();
			out.close();
			bool = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bool;
	}
}
