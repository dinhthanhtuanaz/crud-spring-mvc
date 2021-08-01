package com.laptrinhjavaweb.service.impl;

import java.io.Serializable;
import java.util.List;

//import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.laptrinhjavaweb.repository.MyBaseRepository;
import com.laptrinhjavaweb.service.MyBaseService;
import com.laptrinhjavaweb.utils.Constant;

public class MyBaseServiceImpl<T, ID extends Serializable> implements MyBaseService<T, ID> {

	// Define BaseRepo
	@Autowired
	MyBaseRepository<T, ID> repository;

	@Override
	public List<T> getAll() {
		return repository.findAll();
	}

	@Override
	public T create(T entity) {
		return repository.save(entity);
	}

	@Override
	public T findById(ID id) {
		return repository.findOne(id);
	}

	@Override
	public T update(T entity) {
		return repository.save(entity);
	}

	@Override
	public void deleteById(ID id) {
		repository.delete(id);
	}

	@Override
	public Page<T> paginate(int page) {
		return repository.findAll(new PageRequest(page - 1, Constant.PER_PAGE, sortByIdDesc()));
	}
	
	protected Sort sortByIdDesc() {
		return new Sort(Sort.Direction.DESC, "id");
	}

	@Override
	public String buildPaginationTag(int page, int totalPages, String url) {
		StringBuilder paginationText = new StringBuilder();
		int currentPage = page;
		int totalPage = totalPages;
		
		String beforeDotBtn = currentPage >= 5 ? this.getLinkBtnOfPagination(Constant.DOT_BTN, currentPage, totalPage, url) : "";
		String afterDotBtn = totalPage - currentPage >= 4 ? this.getLinkBtnOfPagination(Constant.DOT_BTN, currentPage, totalPage, url) : "";
		
		String currentPageBtn = getLinkBtnOfPagination(currentPage, currentPage, totalPage, url);
		String beforeCurrentPageBtn = currentPage - 1 > 0 ? this.getLinkBtnOfPagination(currentPage-1, currentPage, totalPage, url) : "";
		String afterCurrentPageBtn = totalPage - currentPage > 0 ? this.getLinkBtnOfPagination(currentPage+1, currentPage, totalPage, url) : "";
		
		String firstPageBtn = currentPage - 2 > 0 ? this.getLinkBtnOfPagination(1, currentPage, totalPage, url) : "";
		String afterFirstPageBtn = currentPage - 2 > 1 ? this.getLinkBtnOfPagination(2, currentPage, totalPage, url) : "";
		
		
		String lastPageBtn = currentPage + 1 <= totalPage  ? "" : this.getLinkBtnOfPagination(totalPage, currentPage, totalPage, url);
		String beforeLastPageBtn = lastPageBtn == "" ? "" : this.getLinkBtnOfPagination(totalPage-1, currentPage, totalPage, url);
		
		lastPageBtn = totalPage - currentPage < 2 ? "" : this.getLinkBtnOfPagination(totalPage, currentPage, totalPage, url);
		beforeLastPageBtn =   totalPage - currentPage < 3 ? "" : this.getLinkBtnOfPagination(totalPage-1, currentPage, totalPage, url);
		
		paginationText.append("<nav aria-label='Page navigation example'>");
		paginationText.append("<ul class='pagination'>");
		
		paginationText.append(firstPageBtn);
		paginationText.append(afterFirstPageBtn);
		
		paginationText.append(beforeDotBtn);
		paginationText.append(beforeCurrentPageBtn);
		paginationText.append(currentPageBtn);
		paginationText.append(afterCurrentPageBtn);
		paginationText.append(afterDotBtn);
		
		paginationText.append(beforeLastPageBtn);
		paginationText.append(lastPageBtn);
		
		paginationText.append("</ul></nav>");
		return paginationText.toString();
	}
	
	private String getLinkBtnOfPagination(int page, int currentPage, int totalPage, String url) {
		String pageText;
		String liClass = "page-item";
		
		switch (page) {
			case Constant.DOT_BTN:
				pageText = "...";
				liClass += " disabled";
				break;
			case Constant.PREV_BTN:
				pageText = "<<";
				break;
			case Constant.NEXT_BTN:
				pageText = ">>";
				break;
			default:
				pageText = page+"";
				break;
			}
		
		if (page == currentPage) {
			liClass += " active";
		}
		
//		if (currentPage == 1 || currentPage == totalPage) {
//			liClass += " disabled";
//		}
		
		return "<li class='"+liClass+"'><a class='page-link' href='"+ url +"&page="+page+"'>"+ pageText + "</a></li>";
	}
}
