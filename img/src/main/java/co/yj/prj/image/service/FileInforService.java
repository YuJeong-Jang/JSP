package co.yj.prj.image.service;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import co.yj.prj.comm.DataSource;
import co.yj.prj.image.vo.FileInformationVO;

public class FileInforService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private FileInforMapper map = sqlSession.getMapper(FileInforMapper.class);
	
	public List<FileInformationVO> FileSelectList() {
		return map.fileSelectList();
	};

	public FileInformationVO fileSelect(int key) {
		return map.fileSelect(key);
	};

	public int fileInsert(FileInformationVO vo) {
		return map.fileInsert(vo);
	};

	public int fileDelete(int key) {
		return map.fileDelete(key);
	};

	public int fileUpdate(FileInformationVO vo) {
		return map.fileUpdate(vo);
	};
}
