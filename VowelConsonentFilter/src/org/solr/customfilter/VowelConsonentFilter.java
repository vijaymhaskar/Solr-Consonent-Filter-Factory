package org.solr.customfilter;

import java.io.IOException;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;


public final class VowelConsonentFilter extends TokenFilter {
	private CharTermAttribute charTermAttr;


	protected VowelConsonentFilter(TokenStream ts) {
		super(ts);
		this.charTermAttr = addAttribute(CharTermAttribute.class);
	}

	@Override
	public boolean incrementToken() throws IOException {
		if (!input.incrementToken()) {
			return false;
		}
            String str = new String(charTermAttr.buffer());
            String vowel="";
            char[] charArray = str.toCharArray();
            for (int x = 0; x < charArray.length; x ++) {
                if (isVowel(charArray[x])) {
                    vowel+=charArray[x];
                }
            }
            charTermAttr.setEmpty();
            charTermAttr.copyBuffer(vowel.toCharArray(), 0, vowel.length());
		return true;
	}
	
	boolean isVowel (char t) {
        return t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u'
                || t == 'A' || t == 'E' || t == 'I' || t == 'O'
                || t == 'U'; 
    }

}
