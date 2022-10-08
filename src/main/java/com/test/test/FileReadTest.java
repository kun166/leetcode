package com.test.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @ClassName: FileReadTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/7/8 12:31
 * @Version: 1.0
 */
public class FileReadTest {

    @Test
    public void test() {
        List<String> wbIdList = getWbIdList();
        List<String> creditId = getCreditId();
        List<Map<String, String>> dataList = new ArrayList<>();
        File root = new File("/Users/qinfajia/code/credit");
        for (String file : root.list()) {
            File first = new File(root.getAbsolutePath() + File.separator + file);
            if (first.isDirectory()) {
                for (String sunFile : new File("/Users/qinfajia/code/credit/" + file).list()) {
                    File second = new File(first.getAbsolutePath() + File.separator + sunFile);
                    if (second.getName().endsWith("2022-07-07-17.credit") || second.getName().endsWith("2022-07-07-18.credit")) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(second))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                if (line.indexOf("更新状态 signCreditContractPushReqDTO") > -1) {
                                    int index = line.indexOf("wbId=") + 5;
                                    String wbId = line.substring(index, line.indexOf(",", index));
                                    if (wbIdList.contains(wbId)) {
                                        Map<String, String> push = new HashMap<>();
                                        dataList.add(push);
                                        push.put("wbId", wbId);
                                        push.put("id", creditId.get(wbIdList.indexOf(wbId)));
                                        push.put("status", "300000102");
                                        // sourceFrom
                                        int sfi = line.indexOf("sourceFrom=") + 11;
                                        push.put("sourceFrom", line.substring(sfi, line.indexOf(",", sfi)));
                                        // investigationOrganization
                                        int ioi = line.indexOf("investigationOrganization=") + "investigationOrganization=".length();
                                        push.put("investigationOrganization", line.substring(ioi, ioi + 1));
                                    }
                                }
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {

                        }
                    }
                }
            }
        }
        System.out.println(dataList.size());
        System.out.println(JSON.toJSONString(dataList));
    }

    @Test
    public void test2() {
        List<String> wbIdList = getWbIdList();
        List<String> creditIdList = getCreditId();
        System.out.println(wbIdList.size() == creditIdList.size());
        System.out.println(wbIdList.get(100) + "-----" + creditIdList.get(100));
        System.out.println(wbIdList.size());
    }

    @Test
    public void test3() {
        List<String> creditIdList = getCreditId();
//        int length = 0, nextLength;
//        while (length < creditIdList.size()) {
//            nextLength = (length + 20 > creditIdList.size()) ? creditIdList.size() : (length + 20);
//            List<String> list = creditIdList.subList(length, nextLength);
//            StringBuilder sql = new StringBuilder("select * from  credit where id in (");
//            for (String s : list) {
//                sql.append(s).append(",");
//            }
//            sql.append(")");
//            System.out.println(sql);
//            length = nextLength;
//        }

        StringBuilder sql = new StringBuilder("select * from  credit where id in (\"");
        for (String s : creditIdList) {
            sql.append(s).append("\",\"");
        }
        sql.append(")");
        System.out.println(sql);

    }


    public List<String> getWbIdList() {
        String str =
                "67991396693771\n" +
                        "32935548916742\n" +
                        "53712397888022\n" +
                        "52495672879377\n" +
                        "71290034744085\n" +
                        "30823844219654\n" +
                        "32291835535625\n" +
                        "54789371354130\n" +
                        "41018476714005\n" +
                        "14034590427399\n" +
                        "35826482812689\n" +
                        "79728021769220\n" +
                        "57895044880153\n" +
                        "68712194992387\n" +
                        "18481822052871\n" +
                        "87224306318374\n" +
                        "48678432762381\n" +
                        "32589502769676\n" +
                        "67006105141783\n" +
                        "88063444394012\n" +
                        "88522766463245\n" +
                        "87740614365740\n" +
                        "78514857394955\n" +
                        "72827494676001\n" +
                        "88374634775580\n" +
                        "42197205430288\n" +
                        "86138598701111\n" +
                        "19299782386951\n" +
                        "1428842416390\n" +
                        "63718637833733\n" +
                        "7447322958598\n" +
                        "60771755858435\n" +
                        "66104993848341\n" +
                        "61752850843907\n" +
                        "73710579006996\n" +
                        "34318120987147\n" +
                        "55114004003599\n" +
                        "88728026981395\n" +
                        "38708568789007\n" +
                        "86294678324517\n" +
                        "78639005280049\n" +
                        "83176443800840\n" +
                        "72522500731409\n" +
                        "59453754873111\n" +
                        "69961487726100\n" +
                        "88888294467589\n" +
                        "88686909791498\n" +
                        "52491416\n" +
                        "83350631508531\n" +
                        "56940228995604\n" +
                        "89018444131896\n" +
                        "79404953583906\n" +
                        "43897958543639\n" +
                        "70070214800643\n" +
                        "81148780162563\n" +
                        "38856691155471\n" +
                        "67962340591888\n" +
                        "89018074032396\n" +
                        "64954761931019\n" +
                        "57875953712150\n" +
                        "56042712257044\n" +
                        "88644809871910\n" +
                        "88886705851157\n" +
                        "35560667545622\n" +
                        "50754324110359\n" +
                        "88886464058679\n" +
                        "58798953925645\n" +
                        "82167124303112\n" +
                        "54822186738447\n" +
                        "58634519520015\n" +
                        "47947692732176\n" +
                        "75305330393119\n" +
                        "63134784790543\n" +
                        "64866429277190\n" +
                        "45888268875277\n" +
                        "35048858364678\n" +
                        "72081040073500\n" +
                        "86858243930405\n" +
                        "87115715490833\n" +
                        "21912873984006\n" +
                        "40337166245390\n" +
                        "77834646723090\n" +
                        "83600812615964\n" +
                        "47234958163479\n" +
                        "79427272676638\n" +
                        "57899373072405\n" +
                        "56818085530644\n" +
                        "88994348431139\n" +
                        "31684175135754\n" +
                        "88490561996072\n" +
                        "87962477806345\n" +
                        "24588141512198\n" +
                        "56505353793305\n" +
                        "89018345540145\n" +
                        "73579464444447\n" +
                        "58717656439309\n" +
                        "37884431791638\n" +
                        "89017861676034\n" +
                        "83994052853809\n" +
                        "72033069700107\n" +
                        "81161754670861\n" +
                        "67582011069463\n" +
                        "80617712396081\n" +
                        "28173892356871\n" +
                        "80346706871593\n" +
                        "59064258527764\n" +
                        "78780741568307\n" +
                        "84506955777060\n" +
                        "83869569845265\n" +
                        "71251461416965\n" +
                        "51642502747151\n" +
                        "46235709933847\n" +
                        "43885351635732\n" +
                        "46882782607639\n" +
                        "82565155305784\n" +
                        "85121085781008\n" +
                        "3461519551494\n" +
                        "55310626833677\n" +
                        "54046340806167\n" +
                        "82314951093797\n" +
                        "77456055676690\n" +
                        "72590674249493\n" +
                        "87434241664272\n" +
                        "88952042057236\n" +
                        "74112818094344\n" +
                        "58534878519054\n" +
                        "39825014580500\n" +
                        "67119610947607\n" +
                        "60600552384524\n" +
                        "57881971502355\n" +
                        "88618798696746\n" +
                        "59197198873617\n" +
                        "55371567429905\n" +
                        "30899192474891\n" +
                        "72060298905610\n" +
                        "88977070485803\n" +
                        "85419702359052\n" +
                        "81472042417681\n" +
                        "74550050304008\n" +
                        "89018292357161\n" +
                        "89018229478454\n" +
                        "46066768454414\n" +
                        "85707650926113\n" +
                        "33964763811337\n" +
                        "42796921267729\n" +
                        "89018322620948\n" +
                        "87110756333082\n" +
                        "62968195208466\n" +
                        "42868831665169\n" +
                        "80679479438899\n" +
                        "68692901758992\n" +
                        "87721779889683\n" +
                        "89018389418501\n" +
                        "84658016870706\n" +
                        "83529613054234\n" +
                        "81210829526313\n" +
                        "89013517548848\n" +
                        "35922789791510\n" +
                        "72864583001358\n" +
                        "45707662324749\n" +
                        "48847217542159\n" +
                        "60369646679049\n" +
                        "38700895100690\n" +
                        "83172738463507\n" +
                        "44181300679441\n" +
                        "70863461934099\n" +
                        "82357055368724\n" +
                        "88494113562166\n" +
                        "81255083062535\n" +
                        "89018338486812\n" +
                        "82560660999196\n" +
                        "87189446352941\n" +
                        "15126989009159\n" +
                        "55595422845967\n" +
                        "39547081979668\n" +
                        "89018408949301\n" +
                        "86568965182727\n" +
                        "64913358754056\n" +
                        "58922278020119\n" +
                        "79043307300358\n" +
                        "61990829191430\n" +
                        "51526265816084\n" +
                        "25136350983943\n" +
                        "64848312959496\n" +
                        "89018347033904\n" +
                        "23682830927110\n" +
                        "21341508747271\n" +
                        "88928247835922\n" +
                        "87714873843503\n" +
                        "88968780488235\n" +
                        "81102110981651\n" +
                        "81161137095445\n" +
                        "24499719544582\n" +
                        "85745348662559\n" +
                        "88666789017627\n" +
                        "66239277816849\n" +
                        "71079802674178\n" +
                        "89018226635057\n" +
                        "82800295088417\n" +
                        "71078801276429\n" +
                        "88975944364852\n" +
                        "74575754969353\n" +
                        "89018271926328\n" +
                        "39313804353815\n" +
                        "89015891442473\n" +
                        "72297884867359\n" +
                        "87582238553364\n" +
                        "76251167127591\n" +
                        "89011779509775\n" +
                        "88740129610253\n" +
                        "78897430876462\n" +
                        "46109478068755\n" +
                        "87774861914891\n" +
                        "75596879591431\n" +
                        "64430392761876\n" +
                        "2405086334214\n" +
                        "66080250770700\n" +
                        "87597761227547\n" +
                        "48965864519698\n" +
                        "88104998583567\n" +
                        "73420988985126\n" +
                        "55348980113941\n" +
                        "18059601466375\n" +
                        "88904275380763\n" +
                        "48279631982102\n" +
                        "35762084768270\n" +
                        "76278504594211\n" +
                        "89018379019305\n" +
                        "89018365430057\n" +
                        "2806751548679\n" +
                        "55272485187865\n" +
                        "86921782121997\n" +
                        "89017839389216\n" +
                        "66661893324803\n" +
                        "50509066526998\n" +
                        "89018011578892\n" +
                        "71106615808282\n" +
                        "31506715085830\n" +
                        "49890348930323\n" +
                        "73984760388100\n" +
                        "88372093035537\n" +
                        "89018151967785\n" +
                        "85145199698953\n" +
                        "41000196214545\n" +
                        "49974872064021\n" +
                        "75443955454473\n" +
                        "53826157932053\n" +
                        "79363197753891\n" +
                        "86478152855090\n" +
                        "69163130796816\n" +
                        "79065642942236\n" +
                        "85371653686070\n" +
                        "87830760941840\n" +
                        "65615256953363\n" +
                        "59864816799765\n" +
                        "76549452766214\n" +
                        "74178283887365\n" +
                        "43918370115599\n" +
                        "56767726227221\n" +
                        "79426944139548\n" +
                        "85440366333740\n" +
                        "89018258898727\n" +
                        "53922121450510\n" +
                        "43407731810580\n" +
                        "89018261721653\n" +
                        "50798780884757\n" +
                        "75125744597514\n" +
                        "86474156342820\n" +
                        "53919853318669\n" +
                        "57086112830999\n" +
                        "83135078074383\n" +
                        "81698164124937\n" +
                        "81670664725802\n" +
                        "68164778332429\n" +
                        "64892682286097\n" +
                        "68156757090320\n" +
                        "72209769486864\n" +
                        "69272749389845\n" +
                        "67767816943628\n" +
                        "62143271577871\n" +
                        "89018423576329\n" +
                        "73915088973603\n" +
                        "62103134987022\n" +
                        "70350184164364\n" +
                        "89003840728611\n" +
                        "45395462771987";

        List<String> wbIdList = Arrays.asList(str.split("\n"));
        return wbIdList;
    }


    public List<String> getCreditId() {
        String str =
                "1726786172563598245\n" +
                        "2237985893264336879\n" +
                        "2329096374547630100\n" +
                        "2382667226756105759\n" +
                        "2679138270773225617\n" +
                        "2679194070988366014\n" +
                        "2825988700185005386\n" +
                        "2946306608347957492\n" +
                        "3047360832273346071\n" +
                        "3279482889546909288\n" +
                        "3501500263163334371\n" +
                        "3615038788794000731\n" +
                        "3739643555356419014\n" +
                        "3792480827148207148\n" +
                        "3792545938852440326\n" +
                        "3929001722774914295\n" +
                        "3968326031022197792\n" +
                        "3968334002481521302\n" +
                        "3968382312273700393\n" +
                        "4030824986366732333\n" +
                        "4030866596009897478\n" +
                        "4030872849482272611\n" +
                        "4030880546063695961\n" +
                        "4030903223491014233\n" +
                        "4030907724616754042\n" +
                        "4137284443815690678\n" +
                        "4137298977985031262\n" +
                        "4137303994506840805\n" +
                        "4137306983804076341\n" +
                        "4137310660296092453\n" +
                        "4137380994680620854\n" +
                        "4137383606020728260\n" +
                        "4172762935265905243\n" +
                        "4172762935265905402\n" +
                        "4172762935265905525\n" +
                        "4172762935265905758\n" +
                        "4172762935265905997\n" +
                        "4172762935265906586\n" +
                        "4172762935265906666\n" +
                        "4172762969625641426\n" +
                        "4172762969625641484\n" +
                        "4172762969625641550\n" +
                        "4172762969625641644\n" +
                        "4172762969625641680\n" +
                        "4172762969625641766\n" +
                        "4172762969625641977\n" +
                        "4172762969625642382\n" +
                        "4172762969625642529\n" +
                        "4172762969625642588\n" +
                        "4172762969625642605\n" +
                        "4172762969625642626\n" +
                        "4172762969625642757\n" +
                        "4172762969625642772\n" +
                        "4172795577017360819\n" +
                        "4172795577017362103\n" +
                        "4172795577017364261\n" +
                        "4172795611377099138\n" +
                        "4172795611377099471\n" +
                        "4172795611377099920\n" +
                        "4172795611377100029\n" +
                        "4172795611377100382\n" +
                        "4172795611377100633\n" +
                        "4172795611377101093\n" +
                        "4172795611377101224\n" +
                        "4172795611377101433\n" +
                        "4172795611377101820\n" +
                        "4172795611377102306\n" +
                        "4172795611377102745\n" +
                        "4172795645736837821\n" +
                        "4172795645736838029\n" +
                        "4172795645736838566\n" +
                        "4172795645736838814\n" +
                        "4172808083962136713\n" +
                        "4172808083962137038\n" +
                        "4172808083962137114\n" +
                        "4172808083962137124\n" +
                        "4172808083962137132\n" +
                        "4172808083962137144\n" +
                        "4172808083962137163\n" +
                        "4172808083962137204\n" +
                        "4172808083962137236\n" +
                        "4172808083962137245\n" +
                        "4172808083962137319\n" +
                        "4172808083962137325\n" +
                        "4172808083962137373\n" +
                        "4172808083962137385\n" +
                        "4172808083962137427\n" +
                        "4172808083962137670\n" +
                        "4172808083962137822\n" +
                        "4172808083962137949\n" +
                        "4172808083962138141\n" +
                        "4172808083962138216\n" +
                        "4172808083962138366\n" +
                        "4172808083962138375\n" +
                        "4172808083962138474\n" +
                        "4172808083962138501\n" +
                        "4172808118321873054\n" +
                        "4172808118321873105\n" +
                        "4172808118321873192\n" +
                        "4172808118321873307\n" +
                        "4172808118321873441\n" +
                        "4172808118321873473\n" +
                        "4172808118321873580\n" +
                        "4172808118321873643\n" +
                        "4172808118321873707\n" +
                        "4172808118321873880\n" +
                        "4172808118321874100\n" +
                        "4172808118321874139\n" +
                        "4172808118321874185\n" +
                        "4172808118321874213\n" +
                        "4172808118321874297\n" +
                        "4172816089781185152\n" +
                        "4172816192860400805\n" +
                        "4172816192860400876\n" +
                        "4172816192860400928\n" +
                        "4172816192860401131\n" +
                        "4172816192860401198\n" +
                        "4172816192860401214\n" +
                        "4172816192860401288\n" +
                        "4172816192860401316\n" +
                        "4172816192860401530\n" +
                        "4172816227220136738\n" +
                        "4172816227220136984\n" +
                        "4172816227220137057\n" +
                        "4172816227220137258\n" +
                        "4172816227220137632\n" +
                        "4172816227220137741\n" +
                        "4172816227220137851\n" +
                        "4172816227220137869\n" +
                        "4172816227220137885\n" +
                        "4172816227220137922\n" +
                        "4172816227220137997\n" +
                        "4172816227220138064\n" +
                        "4172816227220138175\n" +
                        "4172816227220138214\n" +
                        "4172822411973054312\n" +
                        "4172822446332788976\n" +
                        "4172822446332789074\n" +
                        "4172822446332789302\n" +
                        "4172822446332789906\n" +
                        "4172822446332790136\n" +
                        "4172822446332790159\n" +
                        "4172822446332790191\n" +
                        "4172822446332790452\n" +
                        "4172822446332790715\n" +
                        "4172822446332791048\n" +
                        "4172822446332791121\n" +
                        "4172822446332791499\n" +
                        "4172822446332791721\n" +
                        "4172822446332791883\n" +
                        "4172822446332791956\n" +
                        "4172822480692527141\n" +
                        "4172822480692527761\n" +
                        "4172822480692527966\n" +
                        "4172822480692528190\n" +
                        "4172822480692528233\n" +
                        "4172822480692528364\n" +
                        "4172822480692529051\n" +
                        "4172822480692529490\n" +
                        "4172822480692529622\n" +
                        "4172831311145298472\n" +
                        "4172831311145298599\n" +
                        "4172831311145298742\n" +
                        "4172831311145299094\n" +
                        "4172831311145299628\n" +
                        "4172831311145299710\n" +
                        "4172831345505034851\n" +
                        "4172831345505035405\n" +
                        "4172831345505035531\n" +
                        "4172831345505035589\n" +
                        "4172831345505036126\n" +
                        "4172831345505036341\n" +
                        "4172831345505036717\n" +
                        "4172831345505037397\n" +
                        "4172831345505037590\n" +
                        "4172831345505038199\n" +
                        "4172831345505038279\n" +
                        "4172831379864772743\n" +
                        "4172831379864773027\n" +
                        "4172831379864773054\n" +
                        "4172840416475973908\n" +
                        "4172840416475975184\n" +
                        "4172840416475975568\n" +
                        "4172840450835710165\n" +
                        "4172840450835711147\n" +
                        "4172840450835711210\n" +
                        "4172840450835711382\n" +
                        "4172840450835711425\n" +
                        "4172840450835712211\n" +
                        "4172840450835712792\n" +
                        "4172840450835713059\n" +
                        "4172840450835713518\n" +
                        "4172840450835713828\n" +
                        "4172840485195448550\n" +
                        "4172840485195448567\n" +
                        "4172848972050833896\n" +
                        "4172848972050834078\n" +
                        "4172848972050834122\n" +
                        "4172848972050834539\n" +
                        "4172848972050834547\n" +
                        "4172848972050834609\n" +
                        "4172848972050834757\n" +
                        "4172848972050834869\n" +
                        "4172848972050835062\n" +
                        "4172848972050835485\n" +
                        "4172848972050835716\n" +
                        "4172848972050835947\n" +
                        "4172848972050836176\n" +
                        "4172848972050836658\n" +
                        "4172848972050836927\n" +
                        "4172848972050837251\n" +
                        "4172848972050837314\n" +
                        "4172848972050837365\n" +
                        "4172849006410572075\n" +
                        "4172849006410572177\n" +
                        "4172849006410573739\n" +
                        "4172849006410574245\n" +
                        "4172849006410574380\n" +
                        "4172854641407674700\n" +
                        "4172855328602440784\n" +
                        "4172855397321919064\n" +
                        "4172855397321919169\n" +
                        "4172855397321919963\n" +
                        "4172855431681656239\n" +
                        "4172855431681656264\n" +
                        "4172855431681657492\n" +
                        "4172855431681657505\n" +
                        "4172855431681657624\n" +
                        "4172855431681657854\n" +
                        "4172855431681658854\n" +
                        "4172855466041393356\n" +
                        "4172855466041393370\n" +
                        "4172855466041393650\n" +
                        "4172861478995618192\n" +
                        "4172862922104630409\n" +
                        "4172862922104630421\n" +
                        "4172862922104630870\n" +
                        "4172862922104630985\n" +
                        "4172862956464366592\n" +
                        "4172862956464366794\n" +
                        "4172862956464367036\n" +
                        "4172862956464367103\n" +
                        "4172862956464367148\n" +
                        "4172862956464367461\n" +
                        "4172862956464367484\n" +
                        "4172862956464367578\n" +
                        "4172862956464367631\n" +
                        "4172862956464368290\n" +
                        "4172862956464368296\n" +
                        "4172862956464368497\n" +
                        "4172862956464368889\n" +
                        "4172862956464368958\n" +
                        "4172862956464369545\n" +
                        "4172862990824103986\n" +
                        "4172862990824104235\n" +
                        "4172862990824105020\n" +
                        "4172862990824105413\n" +
                        "4172862990824106136\n" +
                        "4172862990824106186\n" +
                        "4172871134082108489\n" +
                        "4172871134082108643\n" +
                        "4172871134082108651\n" +
                        "4172871134082109087\n" +
                        "4172871134082109095\n" +
                        "4172871168441843804\n" +
                        "4172871168441843937\n" +
                        "4172871168441843988\n" +
                        "4172871168441844108\n" +
                        "4172871168441844395\n" +
                        "4172871168441844406\n" +
                        "4172871168441844708\n" +
                        "4172871168441845637\n" +
                        "4172871168441845794\n" +
                        "4172871168441845917\n" +
                        "4172871168441846138\n" +
                        "4172871168441846227\n" +
                        "4172871168441846803\n" +
                        "4172871168441847197\n" +
                        "4172871168441847584\n" +
                        "4172871202801582918\n" +
                        "4172871202801583147\n" +
                        "4172871202801583267\n" +
                        "4172871202801583319\n" +
                        "4172871202801583862\n" +
                        "4172871202801584163\n" +
                        "4172871202801584180";
        List<String> creditIdList = Arrays.asList(str.split("\n"));
        return creditIdList;
    }


    @Test
    public void countError() {
        int count = 0;
        File root = new File("/Users/qinfajia/code/error.log");
        try (BufferedReader reader = new BufferedReader(new FileReader(root))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.indexOf("【助贷服务RPC】获取还款计划异常") > -1) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("中银拉取错误数据量：" + count);
    }
}