package org.alanhou.mapper;

import org.alanhou.my.mapper.MyMapper;
import org.alanhou.pojo.Category;
import org.alanhou.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryMapperCustom {

    public List<CategoryVO> getSubCatList(Integer rootCatId);
}