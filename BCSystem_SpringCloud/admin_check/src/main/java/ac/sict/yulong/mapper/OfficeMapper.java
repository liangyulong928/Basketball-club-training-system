package ac.sict.yulong.mapper;

import ac.sict.yulong.pojo.Office;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OfficeMapper extends Mapper<Office> {

    @Select("SELECT office_id,office_name " +
            "FROM office,admin WHERE office.office_id = admin.office " +
            "AND admin.id = #{id}")
    public List<Office> searchOfficeById(String id);

    @Select("select * from office where office_id like concat(#{office},'%')")
    public List<Office> searchOfficeListByOffice(String office);
}
