package org.solr.customfilter;


import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;


public class VowelFilterFactory extends TokenFilterFactory {
    public VowelFilterFactory(Map<String, String> args) {
        super(args);
    }

    @Override
    public TokenStream create(TokenStream input) {
        return new VowelConsonentFilter(input);
    }
}
