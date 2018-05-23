package com.joylink.userms.services;

import com.github.pagehelper.Page;
import com.joylink.userms.entity.SysDictionary;
import com.joylink.userms.vo.client.DictionaryVO;
import com.joylink.userms.vo.client.PageVO;

public interface ISysDictionaryService {

	Page<SysDictionary> queryPage(DictionaryVO dicVO, PageVO pageInfo);

	void createDic(DictionaryVO dicVO);

}
