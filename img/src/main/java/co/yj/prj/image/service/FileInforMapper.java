package co.yj.prj.image.service;

import java.util.List;

import co.yj.prj.image.vo.FileInformationVO;

public interface FileInforMapper {
	List<FileInformationVO> fileSelectList();

	FileInformationVO fileSelect(int key);

	int fileInsert(FileInformationVO vo);

	int fileDelete(int key);

	int fileUpdate(FileInformationVO vo);
}
