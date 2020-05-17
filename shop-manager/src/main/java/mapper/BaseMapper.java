package mapper;

import tk.mybatis.mapper.common.*;

/**
 * @author Neo
 * @date 2020/5/9 22:29
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>
{
}