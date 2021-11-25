import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.uzykj.mall.MallApplication;
import com.uzykj.mall.util.HttpClient;
import entity.Base;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @program: uzy-ssm-mall-master
 * @description: 爬虫
 * @author: Mr.Gao
 * @create: 2021-11-25 13:55
 *
 * https://b2b.baidu.com/land/recommajax?ajax=1&csrf_token=db961e8635ed2f9ee6bde1879cc252fe&logid=4411862983727229952&fid=42509496%2C1637816931298&_=1637817180771&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&prod_type=0&id=8715a36961ba8991696fc090373f9eca&xzhid=31682484&tpName=%E4%BB%9F%E6%B8%94%E7%BD%91&title=%E5%A4%A7%E5%8E%85%E8%A3%85%E9%A5%B0%E8%90%BD%E5%9C%B0%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD%E6%91%86%E4%BB%B6+%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA+%E5%AE%A4%E5%86%85%E6%A4%8D%E7%89%A9%E7%9B%86%E6%A0%BD%E9%80%A0%E6%99%AF&brandName=%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&p=1&dedup_id=642f438c46264e7aaad0959d947d918a
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class getNetWorkData {
    public static void main(String[] args) throws IOException {
        String s = "{\n" +
                "    \"status\": 0,\n" +
                "    \"data\": {\n" +
                "        \"board\": [],\n" +
                "        \"itemListBT\": [],\n" +
                "        \"itemListBD\": [\n" +
                "            {\n" +
                "                \"id\": \"3e58446e8a5c5d84eefc05f5b633d01b\",\n" +
                "                \"category\": \"食品农业;园林植物;多浆多肉\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=http%3A%2F%2Fwww.qianyuwang.com%2Foffer%2F350863787.html&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E5%9B%AD%E6%9E%97%E6%A4%8D%E7%89%A9%3B%E5%A4%9A%E6%B5%86%E5%A4%9A%E8%82%89&sv_cr=0&uign=415bf6a6422d2099229fb0c219f0e8b4&iid=3e58446e8a5c5d84eefc05f5b633d01b&timeSignOri=1637828772&xzhid=31682484&miniId=8469&qid=&ii_pos=0&fromRec=pccdb&recid=8040e6a&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=3e58446e8a5c5d84eefc05f5b633d01b10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=743415496,3981471293&fm=199&app=68&f=JPEG?w=375&h=375&s=9C90FFB248B3E3E316BB125C030010E4\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"仟渔网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"15.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1,\n" +
                "                \"unit\": \"盆\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"多肉组合 绿植花卉多肉植物 办公室室内盆栽批发租赁\",\n" +
                "                \"fullProviderName\": \"上海优林园艺有限公司\",\n" +
                "                \"location\": \"上海\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"室内\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"优林园艺品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"f0ae1e3f971c4323adb7e7ecfda6dd7d\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"1.84\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"2a4b32e3921476a58248c6f3c552900e\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=http%3A%2F%2Fwww.qianyuwang.com%2Foffer%2F352883801.html&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=35d8372a9a479d891699e20f6ed3e6f&iid=2a4b32e3921476a58248c6f3c552900e&timeSignOri=1637828772&xzhid=31200700&miniId=8469&qid=&ii_pos=1&fromRec=pccdb&recid=8040e6a&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=2a4b32e3921476a58248c6f3c552900e10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1731808488,3412386823&fm=199&app=68&f=JPEG?w=375&h=375&s=19D33BDFC80176C645B4822703002067\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"仟渔网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"2.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 10,\n" +
                "                \"unit\": \"株\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"自家绣球 绣球小苗 花坛租摆 园林绿化 工程绿化用草花\",\n" +
                "                \"fullProviderName\": \"青州超清花卉苗木有限公司\",\n" +
                "                \"location\": \"山东潍坊\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 1,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"多色系\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"超清花卉品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"7e5770ae646d43f69f4e8ce65520662a\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"3.04\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"536acc0230807a5e9fb5762bc551c315\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=http%3A%2F%2Fwww.51sole.com%2Ftp%2F316948997.htm&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=5b3e6024a0f79408b90013da558018a&iid=536acc0230807a5e9fb5762bc551c315&timeSignOri=1637828772&xzhid=33766930&miniId=8469&qid=&ii_pos=2&fromRec=pccdb&recid=8040e6a&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=536acc0230807a5e9fb5762bc551c31510\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1505226395,189454438&fm=199&app=68&f=JPEG?w=375&h=375&s=B9C80ED9E222C6EC00A5F71A030050D7\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"搜了网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"0.60\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1000,\n" +
                "                \"unit\": \"株\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"山东九里香供货商 潍高 售卖九里香苗 保质保量\",\n" +
                "                \"fullProviderName\": \"潍坊潍高花卉苗木有限公司\",\n" +
                "                \"location\": \"山东潍坊\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"中小型\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"潍高花卉品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"204e8b112dbf4ef08630077bb1ae7601\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"3.08\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"3ca587786b85372bb65bc79e9cb7b95a\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fitem.qianyuwang.com%2F345853115.html&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=7ce59282ff137eb938d66245813b9d02&iid=3ca587786b85372bb65bc79e9cb7b95a&timeSignOri=1637828772&xzhid=31200700&miniId=8469&qid=&ii_pos=3&fromRec=pccdb&recid=8040e6a&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=3ca587786b85372bb65bc79e9cb7b95a10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=760714603,1978031322&fm=199&app=68&f=JPEG?w=375&h=375&s=9B0B4ECBCABF83CE0AE1743603005040\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"仟渔网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"1.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1000,\n" +
                "                \"unit\": \"株\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"自家种植四季海棠 量大 四季海棠绿化 花帯用四季海棠 花坛租摆\",\n" +
                "                \"fullProviderName\": \"青州超清花卉苗木有限公司\",\n" +
                "                \"location\": \"山东潍坊\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 1,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"超清花卉品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"30ecda162a524d7690ce6243fa6e6ebc\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"2.98\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"5a0ed5d1a6fc5376bb0dd0f5d45a2d6d\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fwww.bjweizhifu.com%2Fsell%2Fshow-103163028903071951.html&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=4acfa40a14bb758b1c32d49eacb17d2d&iid=5a0ed5d1a6fc5376bb0dd0f5d45a2d6d&timeSignOri=1637828772&xzhid=29420942&miniId=8469&qid=&ii_pos=4&fromRec=pccdb&recid=8040e6a&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=5a0ed5d1a6fc5376bb0dd0f5d45a2d6d10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=839459933,660526033&fm=199&app=68&f=JPEG?w=375&h=375&s=33A003AA5423BEE80E18CFA703008086\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"微智服采购网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"1.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 100,\n" +
                "                \"unit\": \"棵\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"黑麦草批发 地被菊草花 量大从优\",\n" +
                "                \"fullProviderName\": \"河南绿森生态园林有限公司\",\n" +
                "                \"location\": \"河南信阳\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"黑麦草\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"绿森品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"7b0091d007284ba1af5315db7e58e9f0\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"2.24\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"7442dd199d72b7021ef4a2e62943bbb6\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=http%3A%2F%2Fwww.51sole.com%2Ftp%2F327923177.htm&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=2368095a23c768d1387d46a888b658ad&iid=7442dd199d72b7021ef4a2e62943bbb6&timeSignOri=1637828772&xzhid=33589701&miniId=8469&qid=&ii_pos=5&fromRec=pccdb&recid=4efbccd&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=7442dd199d72b7021ef4a2e62943bbb610\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=4095728068,2969895799&fm=199&app=68&f=JPEG?w=375&h=375&s=59FAFAFA4AB3E1FB1A85723D030010D7\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"搜了网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"15.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1000,\n" +
                "                \"unit\": \"棵\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"客厅办公室植物绿萝 批发盆栽绿植绿萝种植基地\",\n" +
                "                \"fullProviderName\": \"青州市云泽花卉苗木专业合作社\",\n" +
                "                \"location\": \"山东潍坊\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"实地验商\",\n" +
                "                        \"type\": \"verify_sm_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"云泽花卉品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": 1,\n" +
                "                \"verifyList\": [\n" +
                "                    1\n" +
                "                ],\n" +
                "                \"dedup_id\": \"ad0d84c130344aa29e7d34effddac2e7\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"senior_type\": 1,\n" +
                "                \"sku_score\": \"3.03\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"09ace56a9676bb0fc82d0a70bff6f709\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=http%3A%2F%2Fwww.51sole.com%2Ftp%2F266740291.htm&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=63867f40b533739b4ad6ac6ef1f191ef&iid=09ace56a9676bb0fc82d0a70bff6f709&timeSignOri=1637828772&xzhid=31200422&miniId=8469&qid=&ii_pos=6&fromRec=pccdb&recid=8040e6a&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=09ace56a9676bb0fc82d0a70bff6f70910\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=473305634,854698371&fm=199&app=68&f=JPEG?w=375&h=375&s=2C913BDB02E5A3494E98391C03008043\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"搜了网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"11.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1,\n" +
                "                \"unit\": \"平方米\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"鹤望兰 罗湖红掌供应\",\n" +
                "                \"fullProviderName\": \"深圳市语花香园艺有限公司\",\n" +
                "                \"location\": \"广东深圳\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"南韵竹风品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"ad40ea9314164e678379d8701cd82d6c\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"2.75\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"0c67fa4cf29989c5c4e768ef66621e0b\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fitem.qianyuwang.com%2F346104355.html&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=40c6aebf61e25bbe1e05e8d6dcfc89f8&iid=0c67fa4cf29989c5c4e768ef66621e0b&timeSignOri=1637828772&xzhid=31304470&miniId=8469&qid=&ii_pos=7&fromRec=pccdb&recid=8040e6a&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=0c67fa4cf29989c5c4e768ef66621e0b10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2857901660,3548168926&fm=199&app=68&f=JPEG?w=375&h=375&s=DD3326D1826192EC5AC9F32603006045\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"仟渔网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"1.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1,\n" +
                "                \"unit\": \"棵\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"国庆菊草花基地草花批发草花 草花基地\",\n" +
                "                \"fullProviderName\": \"青州市乡情花卉苗木专业合作社\",\n" +
                "                \"location\": \"山东潍坊\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 1,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"1e9f8c75b25140109471140988090f33\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"2.66\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"3eaead767ed975e6180b76080c3f1118\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=http%3A%2F%2Fwww.51sole.com%2Ftp%2F302728032.htm&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=888e3cb0cdd7f532b567798665a7633&iid=3eaead767ed975e6180b76080c3f1118&timeSignOri=1637828772&xzhid=33555274&miniId=8469&qid=&ii_pos=8&fromRec=pccdb&recid=8040e6a&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=3eaead767ed975e6180b76080c3f111810\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=587188369,3188145607&fm=199&app=68&f=JPEG?w=375&h=375&s=36E06AB0CCB3FFCC742DF34403004075\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"搜了网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"0.18\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 300,\n" +
                "                \"unit\": \"件\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"旭腾 出售长春花小苗 天天开 培育长春花基地\",\n" +
                "                \"fullProviderName\": \"青州旭腾花卉苗木有限公司\",\n" +
                "                \"location\": \"山东潍坊\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"多色系\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"全kg\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"f74c89c5c9924a1e970618b07a5e475a\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"2.52\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"8aa2abbc1ea7ded8ee872e1eaf29c01c\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fb2bwork.baidu.com%2Fland%3Fomd%3Dca12ef0e1f850de7780b4b0f8cc7bd88&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=6c6adf2a6175a5a76f36354372d5f2d8&iid=8aa2abbc1ea7ded8ee872e1eaf29c01c&timeSignOri=1637828772&xzhid=31243044&miniId=8469&qid=&ii_pos=9&fromRec=pccdb&recid=d0c69d6&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=8aa2abbc1ea7ded8ee872e1eaf29c01c10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2058965574,691669778&fm=199&app=68&f=JPEG?w=375&h=375&s=C50AD6B2562676AC542754700300903A\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"微智服采购网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"9.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1,\n" +
                "                \"unit\": \"个\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"办公室盆景租赁 室内外绿植租赁 郑州花卉批发 价格优惠 品种齐全\",\n" +
                "                \"fullProviderName\": \"郑州名卉源花卉有限公司\",\n" +
                "                \"location\": \"河南郑州\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"室内\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"bc4ed423def245738228879e7367058f\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"1.97\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"13535c45036d3d16b40752e2d8a19302\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=http%3A%2F%2Fwww.51sole.com%2Ftp%2F306091219.htm&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=6d6806352030f5aa729f47522245ddf5&iid=13535c45036d3d16b40752e2d8a19302&timeSignOri=1637828772&xzhid=30515247&miniId=8469&qid=&ii_pos=10&fromRec=pccdb&recid=8040e6a&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=13535c45036d3d16b40752e2d8a1930210\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=43762032,1666502291&fm=199&app=68&f=JPEG?w=375&h=375&s=71E5A7E2584330CCC83381210300204B\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"搜了网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"0.12\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 20000,\n" +
                "                \"unit\": \"棵\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"济宁 大花马齿笕 龙须牡丹苗 多年观赏的效果\",\n" +
                "                \"fullProviderName\": \"青州冠杰花卉苗木有限公司\",\n" +
                "                \"location\": \"山东潍坊\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"多色系\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"中小型\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"ea119e6233264e8aa23a91116ce2a1a4\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"2.44\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"e29d4ab3bf0ffe3ff0acc998a54eed59\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fb2bwork.baidu.com%2Fland%3Flid%3D1715212191108730890&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=64febb10e202cfc07494791ed34e5e5c&iid=e29d4ab3bf0ffe3ff0acc998a54eed59&timeSignOri=1637828772&xzhid=34305200&miniId=8469&qid=&ii_pos=11&fromRec=pccdb&recid=4efbccd&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=e29d4ab3bf0ffe3ff0acc998a54eed5910\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2151120216,3283556575&fm=199&app=68&f=JPEG?w=375&h=375&s=900467B1D4404EFE501079040300E0C5\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"典汇传播\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"面议\",\n" +
                "                \"pCurrency\": \"\",\n" +
                "                \"minValue\": 1,\n" +
                "                \"unit\": \"\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"西安租赁绿植盆栽 盆景植物花卉花卉绿植批发市场千木园林\",\n" +
                "                \"fullProviderName\": \"西安千木园林景观有限责任公司\",\n" +
                "                \"location\": \"陕西西安\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"其他盆栽\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"新中式\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"a737fe1f76f849cd9703e177b07ff230\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"1.36\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"f66ffe3454a9647857cd2d2c18bbaa35\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fwww.zhaosw.com%2Fproduct%2Fdetail%2F241642058&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=7b361fdac6a9079b5f3d2d2fc473b009&iid=f66ffe3454a9647857cd2d2c18bbaa35&timeSignOri=1637828772&xzhid=31753920&miniId=8469&qid=&ii_pos=12&fromRec=pccdb&recid=4efbccd&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=f66ffe3454a9647857cd2d2c18bbaa3510\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3604695838,3733470748&fm=199&app=68&f=JPEG?w=375&h=375&s=F9502ED774C057E9452CC75E03001073\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"找商网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"25.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 10,\n" +
                "                \"unit\": \"盆\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"武汉花卉绿植批发 盆栽绿植花卉价格 大型盆栽植物 润泽蔚来 b000282\",\n" +
                "                \"fullProviderName\": \"武汉润泽蔚来园林景观设计有限公司\",\n" +
                "                \"location\": \"湖北武汉\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"大型\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"润泽蔚来品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"411f9dc988e14912ad35878df9ea4de2\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"3.08\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"46f24e786310faf0e9a6bde23994dc2e\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=http%3A%2F%2Fshineiguanyezhiwu.cailiao.com%2Fsupply%2F29526712.html&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=3658bb5b56354cb64e35fdba0299a31a&iid=46f24e786310faf0e9a6bde23994dc2e&timeSignOri=1637828772&xzhid=30751342&miniId=8469&qid=&ii_pos=13&fromRec=pccdb&recid=4efbccd&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=46f24e786310faf0e9a6bde23994dc2e10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=223538041,4035918583&fm=199&app=68&f=JPEG?w=375&h=375&s=398A66DBDE72F7CE5E15D22B03005055\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"中国材料网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"0.22\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1500,\n" +
                "                \"unit\": \"棵\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"盆栽文竹 室内绿植盆栽文竹 苗圃出售 大量供应盆栽文竹\",\n" +
                "                \"fullProviderName\": \"青州市百世花卉苗木专业合作社\",\n" +
                "                \"location\": \"山东潍坊\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"室内\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"文竹\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"795c56102cfd4db0a21edaccb2ddb4fc\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"1.56\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"a854994d9d6e28e23b94dd9cb34d1d6e\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fwww.zhaosw.com%2Fproduct%2Fdetail%2F222529674&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=3906e554dbcfb855ffff6f244e0fb89&iid=a854994d9d6e28e23b94dd9cb34d1d6e&timeSignOri=1637828772&xzhid=31753920&miniId=8469&qid=&ii_pos=14&fromRec=pccdb&recid=4efbccd&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=a854994d9d6e28e23b94dd9cb34d1d6e10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3097935053,1875825961&fm=199&app=68&f=JPEG?w=375&h=375&s=B55AE77F0AD073D4C5095F660300706C\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"找商网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"25.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 10,\n" +
                "                \"unit\": \"盆\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"室内盆栽租赁-盆景植物批发-绿植租赁价格 润泽蔚来\",\n" +
                "                \"fullProviderName\": \"武汉润泽蔚来园林景观设计有限公司\",\n" +
                "                \"location\": \"湖北武汉\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"室内\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"润泽蔚来品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"b0d46649839c44fabcc0244f0d03a504\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"3.29\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"b709e4d36ba8e85390bb8ee35a8cfb9c\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fb2bwork.baidu.com%2Fland%3Flid%3D1713316699361753203&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=4e9d2ca9e748509b31b4edf8c50bfa8&iid=b709e4d36ba8e85390bb8ee35a8cfb9c&timeSignOri=1637828772&xzhid=35622230&miniId=8469&qid=&ii_pos=15&fromRec=pccdb&recid=4efbccd&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=b709e4d36ba8e85390bb8ee35a8cfb9c10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2198184038,221965035&fm=199&app=68&f=JPEG?w=375&h=375&s=1685B144D840F0DE843415160300C0D0\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"典汇传播\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"120.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 10,\n" +
                "                \"unit\": \"个\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"大型绿植盆栽 盆栽花卉 办公绿化厂家供应 大量批发 叶之青\",\n" +
                "                \"fullProviderName\": \"西安叶之青园林景观服务有限公司\",\n" +
                "                \"location\": \"陕西西安\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"其他盆栽\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"现代简约\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"310dab5afd204cb5ade2c115b710e088\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"1.33\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"5b6218ae6a6d32433733b3113fcd1bec\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;盆景\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fwww.912688.com%2Fsupply%2F317284214.html&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%9B%86%E6%99%AF&sv_cr=0&uign=556973df0103a3b5447b5c033b11127c&iid=5b6218ae6a6d32433733b3113fcd1bec&timeSignOri=1637828772&xzhid=27569374&miniId=8469&qid=&ii_pos=16&fromRec=pccdb&recid=4efbccd&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=5b6218ae6a6d32433733b3113fcd1bec10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2460734411,907095632&fm=199&app=68&f=JPEG?w=375&h=375&s=AB7262955801F6DA172CB75F0300D067\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"搜好货网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"37.50\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1,\n" +
                "                \"unit\": \"棵\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"巴西木盆栽 大盆栽 室内绿植 办公室 居家摆放 树盆景绿植吸粉尘绿植\",\n" +
                "                \"fullProviderName\": \"沭阳勿忘我园林绿化工程有限公司\",\n" +
                "                \"location\": \"江苏宿迁\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 1,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"室内\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"泽远花卉品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"def58141bbd046859c3fb03545eaff40\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"2.55\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"88a589d58761a66e4258fefae92dca6e\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fb2bwork.baidu.com%2Fland%3Flid%3D1688940618813350021&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=1531933f89acbc7b12cc46bb19a78db2&iid=88a589d58761a66e4258fefae92dca6e&timeSignOri=1637828772&xzhid=31861661&miniId=8469&qid=&ii_pos=17&fromRec=pccdb&recid=d0c69d6&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=88a589d58761a66e4258fefae92dca6e10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=866906819,1244250872&fm=199&app=68&f=JPEG?w=375&h=375&s=59927D934E3C5088154DA15F0300C0F0\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"百度爱采购\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"200.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1,\n" +
                "                \"unit\": \"件\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"琴叶榕 大型室内盆栽 室内净化空气 客厅植物琴叶榕\",\n" +
                "                \"fullProviderName\": \"宁波市鄞州绿宝石园林有限公司\",\n" +
                "                \"location\": \"浙江宁波\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"真实性已核验\",\n" +
                "                        \"type\": \"verify_cpa_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"大型\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"室内\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"6db73fe919d54eba87be853d9915bd47\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"1.53\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"1b246131e91f818c949964cfae8de35a\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=http%3A%2F%2Fwww.51sole.com%2Ftp%2F295441243.htm&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=5f7aa818373d52ff783940e8e9983bbd&iid=1b246131e91f818c949964cfae8de35a&timeSignOri=1637828772&xzhid=28458170&miniId=8469&qid=&ii_pos=18&fromRec=pccdb&recid=7946e39&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=1b246131e91f818c949964cfae8de35a10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3690335900,3798162137&fm=199&app=68&f=JPEG?w=375&h=375&s=A5727B800D062EDE6A115D15030080C0\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"搜了网\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"11.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 1,\n" +
                "                \"unit\": \"平方米\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"植物租赁 办公室绿植养护绿化公司\",\n" +
                "                \"fullProviderName\": \"深圳市南韵竹风景观园林有限公司\",\n" +
                "                \"location\": \"广东深圳\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 2,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [\n" +
                "                    {\n" +
                "                        \"name\": \"实地验商\",\n" +
                "                        \"type\": \"verify_sm_1\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"name\": \"南韵竹风品牌\",\n" +
                "                        \"type\": \"tag\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": 1,\n" +
                "                \"verifyList\": [\n" +
                "                    1\n" +
                "                ],\n" +
                "                \"dedup_id\": \"aa6e2c61c43343d486a76828087e7260\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"senior_type\": 1,\n" +
                "                \"sku_score\": \"2.6\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"0037ac7f3dd2326b29403701c339314d\",\n" +
                "                \"category\": \"食品农业;盆栽与盆景;绿植盆栽\",\n" +
                "                \"qid\": \"4411862983727229952\",\n" +
                "                \"sv_cr\": 0,\n" +
                "                \"jumpUrl\": \"https://b2b.baidu.com/b2bsearch/jump?url=https%3A%2F%2Fwww.zchui.com%2FproductDetail%2F663947.html&query=%E4%B8%8A%E6%B5%B7%E4%BC%98%E6%9E%97%E5%9B%AD%E8%89%BA%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8&logid=4411862983727229952&category=%E9%A3%9F%E5%93%81%E5%86%9C%E4%B8%9A%3B%E7%9B%86%E6%A0%BD%E4%B8%8E%E7%9B%86%E6%99%AF%3B%E7%BB%BF%E6%A4%8D%E7%9B%86%E6%A0%BD&sv_cr=0&uign=48856436c86fe9043bf7658dedfdbb5&iid=0037ac7f3dd2326b29403701c339314d&timeSignOri=1637828772&xzhid=29788046&miniId=8469&qid=&ii_pos=19&fromRec=pccdb&recid=fcb0f2b&tplid=671\",\n" +
                "                \"jUrl\": \"https://b2b.baidu.com/land?id=0037ac7f3dd2326b29403701c339314d10\",\n" +
                "                \"videoTime\": null,\n" +
                "                \"picUrl\": \"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2559905355,3223858666&fm=199&app=68&f=JPEG?w=375&h=375&s=102867B1C4CA06EC0931E516030010F2\",\n" +
                "                \"printinfo\": null,\n" +
                "                \"printfclick\": null,\n" +
                "                \"from\": \"卓采汇\",\n" +
                "                \"corrFrom\": null,\n" +
                "                \"price\": \"50.00\",\n" +
                "                \"pCurrency\": \"元\",\n" +
                "                \"minValue\": 10,\n" +
                "                \"unit\": \"个\",\n" +
                "                \"view_times\": null,\n" +
                "                \"inquiry_times\": null,\n" +
                "                \"fullName\": \"山东聊城无公害无土栽培盆栽韭菜批发 迷你韭菜批发\",\n" +
                "                \"fullProviderName\": \"青州市惠康源蔬菜有限公司\",\n" +
                "                \"location\": \"山东潍坊\",\n" +
                "                \"advert\": 0,\n" +
                "                \"adnew\": null,\n" +
                "                \"timeSign\": 102,\n" +
                "                \"cpaMember\": 1,\n" +
                "                \"cpaDuration\": null,\n" +
                "                \"isPioneerOfPop\": 0,\n" +
                "                \"show_flags\": \"\",\n" +
                "                \"tags\": [],\n" +
                "                \"lginfo\": \"\",\n" +
                "                \"spotCertify\": 0,\n" +
                "                \"seniorRealType\": null,\n" +
                "                \"verifyList\": null,\n" +
                "                \"dedup_id\": \"187589b163a843b984e017867546d8cf\",\n" +
                "                \"store_type\": 0,\n" +
                "                \"store_name\": \"\",\n" +
                "                \"subtitle\": null,\n" +
                "                \"sku_score\": \"2.23\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"logId\": \"4411862983727229952\"\n" +
                "}";
        Base base = JSON.parseObject(s, Base.class);
        base.getData().getItemListBD().forEach(itemListBD -> {

        });
    }



}
