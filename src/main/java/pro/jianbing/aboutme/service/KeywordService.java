package pro.jianbing.aboutme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.jianbing.aboutme.entity.Keyword;
import pro.jianbing.aboutme.repository.KeywordRepositoty;

/**
 * @author 李建兵
 */
@Service
public class KeywordService {

    private final
    KeywordRepositoty keywordRepositoty;

    @Autowired
    public KeywordService(KeywordRepositoty keywordRepositoty) {
        this.keywordRepositoty = keywordRepositoty;
    }

    /**
     * 保存搜索的信息
     * @param keyword
     * @return
     */
    @Transactional
    public Integer saveKeyword(Keyword keyword){
        Keyword save = keywordRepositoty.save(keyword);
        if (save!=null){
            return 1;
        }
        return 0;
    }

    public Long getSumSearch(){
        long count = keywordRepositoty.count();
        return count;
    }
}
