package org.wltea.analyzer.lucene;

import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

public class IKTokenizerFactory extends TokenizerFactory {

	private boolean useSmart;
	private boolean usePinyin;

	public boolean useSmart() {
		return useSmart;
	}

	public void setUseSmart(boolean useSmart) {
		this.useSmart = useSmart;
	}

	public boolean usePinyin() {
		return usePinyin;
	}

	public void setUsePinyin(boolean usePinyin) {
		this.usePinyin = usePinyin;
	}

	public IKTokenizerFactory(Map<String, String> args) {
		super(args);
		String useSmartArg = args.get("useSmart");
		String usePinyinArg = args.get("usePinyin");
		this.setUseSmart(useSmartArg != null ? Boolean.parseBoolean(useSmartArg) : false);
		this.setUsePinyin(usePinyinArg !=null ? Boolean.parseBoolean(usePinyinArg) : false);
	}

	@Override
	public Tokenizer create(AttributeFactory factory) {
		Tokenizer _IKTokenizer = new IKTokenizer(factory, this.useSmart, this.usePinyin);
		return _IKTokenizer;
	}

}
