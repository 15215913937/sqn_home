package com.sqn.library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sqn.library.entity.Book;
import com.sqn.library.mapper.BookMapper;
import com.sqn.library.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 图书信息表 服务实现类
 * </p>
 *
 * @author shenqn
 * @since 2022-07-11
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> OneList(Integer id) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uId", id);
        return list(queryWrapper);
    }

    @Override
    public Page<Book> findPage(Page<Book> page, String name, String author, String category) {
        return bookMapper.findPage(page, name, author, category);
    }

    @Override
    public Page<Book> findPageByUid(Page<Book> page, Integer uid, String name, String author, String category) {
        return bookMapper.findPageByUid(page, uid, name, author, category);
    }
}
