package org.origami.trading.core.worker.marketdata.stocks.models.mappers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.origami.trading.core.worker.daos.rest.byma.BymaRestDaoImpl;
import org.origami.trading.core.worker.marketdata.stocks.models.BymaStock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * Created by dmoreira on 4/16/17.
 */
public class HtmlBymaStockMapperTest {

    private final Logger logger = LoggerFactory.getLogger(HtmlBymaStockMapper.class);
    private String testHtml;
    private HtmlBymaStockMapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = new HtmlBymaStockMapper();
    }

    @Test
    public void unmarshalHappyTest() throws Exception {
        testHtml = getHappyHtml();

        List<BymaStock> unmarshaledStocks = mapper.unmarshal(testHtml);

        /* 24 Stocks should've been unmarshaled */
        Assert.assertEquals(27, unmarshaledStocks.size());

        BymaStock agroCdo = unmarshaledStocks.get(0);
        String agroTicker = agroCdo.getTicker();
        Assert.assertEquals("AGRO", agroTicker);

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Argentina/Buenos_Aires"));
        cal.setTime(agroCdo.getLastTime());
        assertEquals(15, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(37, cal.get(Calendar.MINUTE));
        assertEquals(57, cal.get(Calendar.SECOND));
    }

    @Test
    public void unmarshalSadTest() {
        testHtml = "SadTest - GarbageSample";

        try {
            List<BymaStock> unmarshaledStocks = mapper.unmarshal(testHtml);
        } catch (RuntimeException rE) {
            logger.info("UnmarshalSadTest - Success");
        }
    }


    private String getHappyHtml() {
        return "\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\"/>\n" +
                "<!DOCTYPE html >\n" +
                "\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" >\n" +
                "<head><title>\n" +
                "\n" +
                "</title>\n" +
                "    <link href=\"../App_Themes/BolsarCss/BolsarCss.css\" type=\"text/css\" rel=\"stylesheet\" /></head>\n" +
                "<body>\n" +
                "    <form name=\"aspnetForm\" method=\"post\" action=\"WQAccionesLideres.aspx\" id=\"aspnetForm\">\n" +
                "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"afC4QW0bqusBbAamXtWXpzPu8dGLJMwTyhIcfLHa1L2QsI3AAH267/mncgPKER0vji3JEOHqxcPn9iKvhloM2AtuK7U=\" />\n" +
                "\n" +
                "<input type=\"hidden\" name=\"__VIEWSTATEGENERATOR\" id=\"__VIEWSTATEGENERATOR\" value=\"F7548C65\" />\n" +
                "<input type=\"hidden\" name=\"__VIEWSTATEENCRYPTED\" id=\"__VIEWSTATEENCRYPTED\" value=\"\" />\n" +
                "    <div>\n" +
                "        \n" +
                "<table cellspacing=\"0\" rules=\"all\" border=\"1\" id=\"ctl00_contentFORM_Panel_dgrPanel\">\n" +
                "\t<tr>\n" +
                "\t\t<td>Especie</td><td>Vencimiento</td><td>Estado</td><td>Marca EX</td><td>Cantidad Nominal Compra</td><td>Precio Compra</td><td>Cantidad Nominal Venta</td><td>Precio Venta</td><td>Último</td><td>Tendencia</td><td>Variación %</td><td>Máximo</td><td>Mínimo</td><td>Cierre Ant.</td><td>Vol. Nominal</td><td>Monto Operado ($)</td><td>Cant. Ope.</td><td>Hora Cotización</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>AGRO</td><td>Cdo</td><td></td><td></td><td>400</td><td>36,500</td><td>0</td><td>0,000</td><td>37,400</td><td>=</td><td>-3,36</td><td>37,800</td><td>36,800</td><td>38,700</td><td>3769</td><td>141083</td><td>10</td><td>15:37:57</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>AGRO</td><td>72</td><td></td><td></td><td>392</td><td>37,900</td><td>1279</td><td>38,000</td><td>38,000</td><td>+</td><td>-1,55</td><td>38,400</td><td>36,500</td><td>38,600</td><td>100936</td><td>3807231</td><td>245</td><td>16:59:58</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>ALUA</td><td>Cdo</td><td></td><td></td><td>418</td><td>11,550</td><td>840</td><td>11,650</td><td>11,650</td><td>+</td><td>0,00</td><td>11,650</td><td>11,500</td><td>11,650</td><td>15034</td><td>173444</td><td>11</td><td>15:59:40</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>ALUA</td><td>24</td><td></td><td></td><td>2010</td><td>11,500</td><td>100352</td><td>11,750</td><td>11,650</td><td>=</td><td>0,43</td><td>11,650</td><td>11,650</td><td>11,600</td><td>600</td><td>6990</td><td>1</td><td>11:33:07</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>ALUA</td><td>72</td><td></td><td></td><td>15500</td><td>11,550</td><td>500</td><td>11,650</td><td>11,650</td><td>=</td><td>0,00</td><td>11,750</td><td>11,450</td><td>11,650</td><td>1390864</td><td>16152385</td><td>441</td><td>16:59:57</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>APBR</td><td>Cdo</td><td></td><td></td><td>5000</td><td>73,000</td><td>10000</td><td>73,900</td><td>73,600</td><td>+</td><td>-2,13</td><td>74,050</td><td>73,400</td><td>75,200</td><td>11700</td><td>862262</td><td>10</td><td>15:50:56</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>APBR</td><td>24</td><td></td><td></td><td>0</td><td>0,000</td><td>1000</td><td>74,200</td><td>73,400</td><td>-</td><td>-2,00</td><td>74,000</td><td>73,400</td><td>74,900</td><td>5478</td><td>402980</td><td>3</td><td>16:43:19</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>APBR</td><td>72</td><td></td><td></td><td>1050</td><td>73,350</td><td>3500</td><td>73,450</td><td>73,500</td><td>=</td><td>-1,47</td><td>74,500</td><td>73,200</td><td>74,600</td><td>177512</td><td>13096732</td><td>268</td><td>16:55:35</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>AUSO</td><td>Cdo</td><td></td><td></td><td>1000</td><td>79,000</td><td>100</td><td>81,000</td><td>80,500</td><td>-</td><td>1,90</td><td>81,800</td><td>80,500</td><td>79,000</td><td>850</td><td>69335</td><td>2</td><td>14:50:59</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>AUSO</td><td>24</td><td></td><td></td><td>0</td><td>0,000</td><td>1000</td><td>82,000</td><td>81,500</td><td>=</td><td>2,52</td><td>81,500</td><td>81,500</td><td>79,500</td><td>100</td><td>8150</td><td>1</td><td>13:25:04</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>AUSO</td><td>72</td><td></td><td></td><td>314</td><td>80,500</td><td>400</td><td>81,300</td><td>81,300</td><td>+</td><td>0,68</td><td>82,350</td><td>79,800</td><td>80,750</td><td>29483</td><td>2402909</td><td>126</td><td>16:59:45</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>BMA</td><td>Cdo</td><td></td><td></td><td>0</td><td>0,000</td><td>0</td><td>0,000</td><td>130,100</td><td>=</td><td>0,08</td><td>130,100</td><td>130,100</td><td>130,000</td><td>57</td><td>7415</td><td>1</td><td>15:42:49</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>BMA</td><td>24</td><td></td><td></td><td>0</td><td>0,000</td><td>30</td><td>131,000</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>BMA</td><td>72</td><td></td><td></td><td>493</td><td>127,500</td><td>22</td><td>129,700</td><td>128,000</td><td>=</td><td>-1,92</td><td>131,000</td><td>127,250</td><td>130,500</td><td>60504</td><td>7840412</td><td>169</td><td>16:59:57</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>CECO2</td><td>24</td><td></td><td></td><td>590</td><td>15,400</td><td>1155</td><td>15,900</td><td>15,900</td><td>+</td><td>-0,63</td><td>15,900</td><td>15,850</td><td>16,000</td><td>995</td><td>15780</td><td>2</td><td>13:03:26</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>CECO2</td><td>72</td><td></td><td></td><td>641</td><td>15,600</td><td>5500</td><td>15,750</td><td>15,750</td><td>=</td><td>0,00</td><td>16,100</td><td>15,400</td><td>15,750</td><td>229750</td><td>3601934</td><td>127</td><td>17:00:47</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>CELU</td><td>Cdo</td><td></td><td></td><td>3800</td><td>14,700</td><td>0</td><td>0,000</td><td>14,700</td><td>+</td><td>-6,07</td><td>14,700</td><td>14,250</td><td>15,650</td><td>3164</td><td>45853</td><td>6</td><td>15:47:39</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>CELU</td><td>24</td><td></td><td></td><td>1000</td><td>14,050</td><td>600</td><td>15,000</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>CELU</td><td>72</td><td></td><td></td><td>478</td><td>14,700</td><td>1674</td><td>14,850</td><td>14,850</td><td>=</td><td>-2,62</td><td>15,200</td><td>14,500</td><td>15,250</td><td>169385</td><td>2496173</td><td>215</td><td>16:59:39</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>CEPU</td><td>24</td><td></td><td></td><td>0</td><td>0,000</td><td>0</td><td>0,000</td><td>24,900</td><td>=</td><td>-4,60</td><td>24,900</td><td>24,900</td><td>26,100</td><td>360</td><td>8964</td><td>1</td><td>16:00:56</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>CEPU</td><td>72</td><td></td><td></td><td>2189</td><td>24,400</td><td>1000</td><td>24,700</td><td>24,500</td><td>=</td><td>-2,78</td><td>25,300</td><td>24,400</td><td>25,200</td><td>252292</td><td>6209361</td><td>136</td><td>16:59:57</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>TS</td><td>Cdo</td><td></td><td></td><td>1000</td><td>250,200</td><td>3420</td><td>251,000</td><td>251,000</td><td>-</td><td>-4,56</td><td>254,000</td><td>251,000</td><td>263,000</td><td>5323</td><td>1342739</td><td>19</td><td>15:53:53</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>TS</td><td>24</td><td></td><td></td><td>0</td><td>0,000</td><td>0</td><td>0,000</td><td>256,500</td><td>=</td><td>-0,97</td><td>256,500</td><td>256,500</td><td>259,000</td><td>23</td><td>5899</td><td>1</td><td>12:41:26</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>TS</td><td>72</td><td></td><td></td><td>73</td><td>253,000</td><td>1876</td><td>254,000</td><td>254,000</td><td>+</td><td>-4,69</td><td>263,500</td><td>252,000</td><td>266,500</td><td>77853</td><td>19806311</td><td>475</td><td>16:59:31</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>YPFD</td><td>Cdo</td><td></td><td></td><td>5</td><td>390,950</td><td>398</td><td>394,000</td><td>391,000</td><td>-</td><td>-0,13</td><td>398,000</td><td>390,000</td><td>391,500</td><td>8105</td><td>3187991</td><td>30</td><td>15:37:34</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>YPFD</td><td>24</td><td></td><td></td><td>0</td><td>0,000</td><td>100</td><td>395,000</td><td>392,000</td><td>=</td><td>0,00</td><td>392,000</td><td>392,000</td><td>392,000</td><td>152</td><td>59584</td><td>2</td><td>15:26:48</td>\n" +
                "\t</tr><tr>\n" +
                "\t\t<td>YPFD</td><td>72</td><td></td><td></td><td>75</td><td>395,000</td><td>950</td><td>395,300</td><td>395,300</td><td>-</td><td>0,38</td><td>400,000</td><td>388,050</td><td>393,800</td><td>124031</td><td>48872087</td><td>582</td><td>17:00:00</td>\n" +
                "\t</tr>\n" +
                "</table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "    </div>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>\n";
    }

}