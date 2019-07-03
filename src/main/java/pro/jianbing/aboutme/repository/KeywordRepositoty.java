package pro.jianbing.aboutme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.entity.Keyword;


/**
 * @author 李建兵
 */
@Repository("keywordRepository")
public interface KeywordRepositoty extends JpaRepository<Keyword,String> {
    /**
     * 获取今天的搜索数
     * @return
     */
    @Query("select count(search_time) from Keyword where search_time > current_date")
    Integer countSearchToday();
}
