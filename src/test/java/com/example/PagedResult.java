package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PagedResult implements Page<Person> {
	
	List<Person> content = new ArrayList<>();

	boolean last;
	
	int totalPages;
	
	long totalElements;
	
	int size;
	
	int number;
	
	String sort;
	
	boolean first;
	
	int numberOfElements;

	public PagedResult() {
		super();
	}

	public void setContent(List<Person> content) {
		this.content = content;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int getNumberOfElements() {
		return numberOfElements;
	}

	@Override
	public List<Person> getContent() {
		return this.content;
	}

	@Override
	public boolean hasContent() {
		if(content == null || content.size()==0)
			return false;
		return true;
	}

	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFirst() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pageable nextPageable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pageable previousPageable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Person> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalPages() {
		return totalPages;
	}

	@Override
	public long getTotalElements() {
		return totalElements;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page map(Converter converter) {
		// TODO Auto-generated method stub
		return null;
	}
}
