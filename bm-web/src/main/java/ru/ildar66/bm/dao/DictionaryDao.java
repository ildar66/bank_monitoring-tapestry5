package ru.ildar66.bm.dao;

import java.util.List;

import ru.ildar66.bm.common.entity.Contractor;

/**
 * DAO for Dictionaries
 * 
 * @author Shafigullin Ildar
 * 
 */
public interface DictionaryDao {

	public List<Contractor> getContractors(int startIndex, int i, String contractorNamePattern);

	public int getContractorCount(String contractorNamePattern);

}
