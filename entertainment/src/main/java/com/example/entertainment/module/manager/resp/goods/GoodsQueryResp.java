package com.example.entertainment.module.manager.resp.goods;

import com.example.entertainment.module.entity.Goods;
import com.example.entertainment.module.entity.GoodsCategory;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("商品查询结果")
@Data
public class GoodsQueryResp extends Goods {

}
