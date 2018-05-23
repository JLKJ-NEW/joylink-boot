package com.joylink.userms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.joylink.userms.dao.SysDictionaryMapper;
import com.joylink.userms.entity.SysDictionary;
import com.joylink.userms.entity.SysDictionaryExample;
import com.joylink.userms.exceptions.DBException;
import com.joylink.userms.exceptions.ExceptionMapping;
import com.joylink.userms.vo.client.DictionaryVO;
import com.joylink.userms.vo.client.PageVO;

@Service
public class SysDictionaryService implements ISysDictionaryService {
	
	@Autowired
	private SysDictionaryMapper sysDictionaryMapper;

	@Override
	public Page<SysDictionary> queryPage(DictionaryVO dicVO, PageVO pageInfo) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		SysDictionaryExample example = new SysDictionaryExample();
		Page<SysDictionary> page = (Page<SysDictionary>) sysDictionaryMapper.selectByExample(example);
		return page;
	}

	@Override
	public void createDic(DictionaryVO dicVO) {
		SysDictionaryExample example = new SysDictionaryExample();
		example.createCriteria().andCodeEqualTo(dicVO.getCode());
		List<SysDictionary> list = this.sysDictionaryMapper.selectByExample(example);
		if(null != list && list.size() > 0) {
			throw new DBException(ExceptionMapping.DATA_EXISTS);
		}
		SysDictionary sysDic = new SysDictionary(dicVO);
		this.sysDictionaryMapper.insertSelective(sysDic);
	}
	
}
