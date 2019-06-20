package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service("localeService")
public class LocaleDetailsServiceImpl implements LocaleDetailsService {

	@Override
	public List<String> getAllLanguages() {
	   Locale locales[]=null;
	   List<String> list=null;
	   //get All Locales
	   locales=Locale.getAvailableLocales();
	   //keep all languages in List Collection
	   list=new ArrayList();
	   for(Locale locale:locales){
		   list.add(locale.getDisplayLanguage());
	   }//for
		return list;
	}

	@Override
	public List<String> getAllCountries() {
		 Locale locales[]=null;
		   List<String> list=null;
		   //get All Locales
		   locales=Locale.getAvailableLocales();
		   //keep all languages in List Collection
		   list=new ArrayList();
		   for(Locale locale:locales){
			   list.add(locale.getDisplayCountry());
		   }//for
			return list;
	}

}
