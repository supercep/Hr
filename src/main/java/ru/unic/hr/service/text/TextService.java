package ru.unic.hr.service.text;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BritikovMI on 11.09.2019.
 */
public class TextService {
    public static List<String> getListOfSentences(String content) {
        return Arrays.asList(content.split("\\. (?![^()]*\\))"));
    }

    public static String deleteStopWords(String content) {
        return content
                .replace(" — ", " ")
                .replace(" и ", " ")
                .replace(" в ", " ")
                .replace(" во ", " ")
                .replace(" не ", " ")
                .replace(" что ", " ")
                .replace(" он ", " ")
                .replace(" на ", " ")
                .replace(" я ", " ")
                .replace(" с ", " ")
                .replace(" со ", " ")
                .replace(" как ", " ")
                .replace(" а ", " ")
                .replace(" то ", " ")
                .replace(" все ", " ")
                .replace(" она ", " ")
                .replace(" так ", " ")
                .replace(" его ", " ")
                .replace(" но ", " ")
                .replace(" да ", " ")
                .replace(" ты ", " ")
                .replace(" к ", " ")
                .replace(" у ", " ")
                .replace(" же ", " ")
                .replace(" вы ", " ")
                .replace(" за ", " ")
                .replace(" бы ", " ")
                .replace(" по ", " ")
                .replace(" только ", " ")
                .replace(" ее ", " ")
                .replace(" мне ", " ")
                .replace(" было ", " ")
                .replace(" вот ", " ")
                .replace(" от ", " ")
                .replace(" меня ", " ")
                .replace(" еще ", " ")
                .replace(" нет ", " ")
                .replace(" о ", " ")
                .replace(" из ", " ")
                .replace(" ему ", " ")
                .replace(" теперь ", " ")
                .replace(" когда ", " ")
                .replace(" даже ", " ")
                .replace(" ну ", " ")
                .replace(" вдруг ", " ")
                .replace(" ли ", " ")
                .replace(" если ", " ")
                .replace(" уже ", " ")
                .replace(" или ", " ")
                .replace(" ни ", " ")
                .replace(" быть ", " ")
                .replace(" был ", " ")
                .replace(" него ", " ")
                .replace(" до ", " ")
                .replace(" вас ", " ")
                .replace(" нибудь ", " ")
                .replace(" опять ", " ")
                .replace(" уж ", " ")
                .replace(" вам ", " ")
                .replace(" ведь ", " ")
                .replace(" там ", " ")
                .replace(" потом ", " ")
                .replace(" себя ", " ")
                .replace(" ничего ", " ")
                .replace(" ей ", " ")
                .replace(" может ", " ")
                .replace(" они ", " ")
                .replace(" тут ", " ")
                .replace(" где ", " ")
                .replace(" есть ", " ")
                .replace(" надо ", " ")
                .replace(" ней ", " ")
                .replace(" для ", " ")
                .replace(" мы ", " ")
                .replace(" тебя ", " ")
                .replace(" их ", " ")
                .replace(" чем ", " ")
                .replace(" была ", " ")
                .replace(" сам ", " ")
                .replace(" чтоб ", " ")
                .replace(" без ", " ")
                .replace(" будто ", " ")
                .replace(" чего ", " ")
                .replace(" раз ", " ")
                .replace(" тоже ", " ")
                .replace(" себе ", " ")
                .replace(" под ", " ")
                .replace(" будет ", " ")
                .replace(" ж ", " ")
                .replace(" тогда ", " ")
                .replace(" кто ", " ")
                .replace(" этот ", " ")
                .replace(" того ", " ")
                .replace(" потому ", " ")
                .replace(" этого ", " ")
                .replace(" какой ", " ")
                .replace(" совсем ", " ")
                .replace(" ним ", " ")
                .replace(" здесь ", " ")
                .replace(" этом ", " ")
                .replace(" один ", " ")
                .replace(" почти ", " ")
                .replace(" мой ", " ")
                .replace(" тем ", " ")
                .replace(" чтобы ", " ")
                .replace(" нее ", " ")
                .replace(" сейчас ", " ")
                .replace(" были ", " ")
                .replace(" куда ", " ")
                .replace(" зачем ", " ")
                .replace(" всех ", " ")
                .replace(" никогда ", " ")
                .replace(" можно ", " ")
                .replace(" при ", " ")
                .replace(" наконец ", " ")
                .replace(" два ", " ")
                .replace(" об ", " ")
                .replace(" другой ", " ")
                .replace(" хоть ", " ")
                .replace(" после ", " ")
                .replace(" над ", " ")
                .replace(" больше ", " ")
                .replace(" тот ", " ")
                .replace(" через ", " ")
                .replace(" эти ", " ")
                .replace(" нас ", " ")
                .replace(" про ", " ")
                .replace(" всего ", " ")
                .replace(" них ", " ")
                .replace(" какая ", " ")
                .replace(" много ", " ")
                .replace(" разве ", " ")
                .replace(" три ", " ")
                .replace(" эту ", " ")
                .replace(" моя ", " ")
                .replace(" впрочем ", " ")
                .replace(" хорошо ", " ")
                .replace(" свою ", " ")
                .replace(" этой ", " ")
                .replace(" перед ", " ")
                .replace(" иногда ", " ")
                .replace(" лучше ", " ")
                .replace(" чуть ", " ")
                .replace(" том ", " ")
                .replace(" нельзя ", " ")
                .replace(" такой ", " ")
                .replace(" им ", " ")
                .replace(" более ", " ")
                .replace(" всегда ", " ")
                .replace(" конечно ", " ")
                .replace(" всю ", " ")
                .replace(" между "," ")
                .replace(" i ", " ")
                .replace(" me ", " ")
                .replace(" my ", " ")
                .replace(" myself ", " ")
                .replace(" we ", " ")
                .replace(" our ", " ")
                .replace(" ours ", " ")
                .replace(" ourselves ", " ")
                .replace(" you ", " ")
                .replace(" you're ", " ")
                .replace(" you've ", " ")
                .replace(" you'll ", " ")
                .replace(" you'd ", " ")
                .replace(" your ", " ")
                .replace(" yours ", " ")
                .replace(" yourself ", " ")
                .replace(" yourselves ", " ")
                .replace(" he ", " ")
                .replace(" him ", " ")
                .replace(" his ", " ")
                .replace(" himself ", " ")
                .replace(" she ", " ")
                .replace(" she's ", " ")
                .replace(" her ", " ")
                .replace(" hers ", " ")
                .replace(" herself ", " ")
                .replace(" it ", " ")
                .replace(" it's ", " ")
                .replace(" its ", " ")
                .replace(" itself ", " ")
                .replace(" they ", " ")
                .replace(" them ", " ")
                .replace(" their ", " ")
                .replace(" theirs ", " ")
                .replace(" themselves ", " ")
                .replace(" what ", " ")
                .replace(" which ", " ")
                .replace(" who ", " ")
                .replace(" whom ", " ")
                .replace(" this ", " ")
                .replace(" that ", " ")
                .replace(" that'll ", " ")
                .replace(" these ", " ")
                .replace(" those ", " ")
                .replace(" am ", " ")
                .replace(" is ", " ")
                .replace(" are ", " ")
                .replace(" was ", " ")
                .replace(" were ", " ")
                .replace(" be ", " ")
                .replace(" been ", " ")
                .replace(" being ", " ")
                .replace(" have ", " ")
                .replace(" has ", " ")
                .replace(" had ", " ")
                .replace(" having ", " ")
                .replace(" do ", " ")
                .replace(" does ", " ")
                .replace(" did ", " ")
                .replace(" doing ", " ")
                .replace(" a ", " ")
                .replace(" an ", " ")
                .replace(" the ", " ")
                .replace(" and ", " ")
                .replace(" but ", " ")
                .replace(" if ", " ")
                .replace(" or ", " ")
                .replace(" because ", " ")
                .replace(" as ", " ")
                .replace(" until ", " ")
                .replace(" while ", " ")
                .replace(" of ", " ")
                .replace(" at ", " ")
                .replace(" by ", " ")
                .replace(" for ", " ")
                .replace(" with ", " ")
                .replace(" about ", " ")
                .replace(" against ", " ")
                .replace(" between ", " ")
                .replace(" into ", " ")
                .replace(" through ", " ")
                .replace(" during ", " ")
                .replace(" before ", " ")
                .replace(" after ", " ")
                .replace(" above ", " ")
                .replace(" below ", " ")
                .replace(" to ", " ")
                .replace(" from ", " ")
                .replace(" up ", " ")
                .replace(" down ", " ")
                .replace(" in ", " ")
                .replace(" out ", " ")
                .replace(" on ", " ")
                .replace(" off ", " ")
                .replace(" over ", " ")
                .replace(" under ", " ")
                .replace(" again ", " ")
                .replace(" further ", " ")
                .replace(" then ", " ")
                .replace(" once ", " ")
                .replace(" here ", " ")
                .replace(" there ", " ")
                .replace(" when ", " ")
                .replace(" where ", " ")
                .replace(" why ", " ")
                .replace(" how ", " ")
                .replace(" all ", " ")
                .replace(" any ", " ")
                .replace(" both ", " ")
                .replace(" each ", " ")
                .replace(" few ", " ")
                .replace(" more ", " ")
                .replace(" most ", " ")
                .replace(" other ", " ")
                .replace(" some ", " ")
                .replace(" such ", " ")
                .replace(" no ", " ")
                .replace(" nor ", " ")
                .replace(" not ", " ")
                .replace(" only ", " ")
                .replace(" own ", " ")
                .replace(" same ", " ")
                .replace(" so ", " ")
                .replace(" than ", " ")
                .replace(" too ", " ")
                .replace(" very ", " ")
                .replace(" s ", " ")
                .replace(" t ", " ")
                .replace(" can ", " ")
                .replace(" will ", " ")
                .replace(" just ", " ")
                .replace(" don ", " ")
                .replace(" don't ", " ")
                .replace(" should ", " ")
                .replace(" should've ", " ")
                .replace(" now ", " ")
                .replace(" d ", " ")
                .replace(" ll ", " ")
                .replace(" m ", " ")
                .replace(" o ", " ")
                .replace(" re ", " ")
                .replace(" ve ", " ")
                .replace(" y ", " ")
                .replace(" ain ", " ")
                .replace(" aren ", " ")
                .replace(" aren't ", " ")
                .replace(" couldn ", " ")
                .replace(" couldn't ", " ")
                .replace(" didn ", " ")
                .replace(" didn't ", " ")
                .replace(" doesn ", " ")
                .replace(" doesn't ", " ")
                .replace(" hadn ", " ")
                .replace(" hadn't ", " ")
                .replace(" hasn ", " ")
                .replace(" hasn't ", " ")
                .replace(" haven ", " ")
                .replace(" haven't ", " ")
                .replace(" isn ", " ")
                .replace(" isn't ", " ")
                .replace(" ma ", " ")
                .replace(" mightn ", " ")
                .replace(" mightn't ", " ")
                .replace(" mustn ", " ")
                .replace(" mustn't ", " ")
                .replace(" needn ", " ")
                .replace(" needn't ", " ")
                .replace(" shan ", " ")
                .replace(" shan't ", " ")
                .replace(" shouldn ", " ")
                .replace(" shouldn't ", " ")
                .replace(" wasn ", " ")
                .replace(" wasn't ", " ")
                .replace(" weren ", " ")
                .replace(" weren't ", " ")
                .replace(" won ", " ")
                .replace(" won't ", " ")
                .replace(" wouldn ", " ")
                .replace(" wouldn't ", " ");
    }

}
