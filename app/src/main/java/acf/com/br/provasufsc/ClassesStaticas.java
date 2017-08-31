package acf.com.br.provasufsc;

import org.provasUfsc.aaf.model.Question;
import org.provasUfsc.aaf.model.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Abimael Fidencio on 07/11/2016.
 */
public class ClassesStaticas {

    public static String USER_SAVED = "userSaved";

    public static UsuarioDTO user;
    public static Long idUsuario = 0L;
    public static String idUserSaved = "idDoUserSaved";
    public static String nameGrupo1 = "nameGrupoUM";
    public static String nameGrupo2 = "nameGrupoDOIS";
    public static String nameGrupo3 = "nameGrupoTRES";

    public static String nomeDoUsuario = "NomeDoUsuario";

    public static boolean carregarQuestoes = true;
    public static boolean salvarQuestoes = true;

    public static boolean revisarQuestoes = false;
    public static List<Question> questoesErradas;

    public static String disciplinaSelecionada;

    public static String anoSelecionado;

    public static Integer numeroQuestaoSelecionada = 1;

    public static Integer numeroQuestoesRespondidas = 0;
    public static Integer numeroQuestoesRespondidasCorretaente = 0;
    public static Integer numeroQuestoesRespondidasErroneamente = 0;

    public static String totalSimuladoFeitoFile = "totalSimuladoFeito";
    public static int totalSimuladoFeitoV = 0;

    public static String qtdeQuestoesTotalFile = "percetualAcertoTotal";
    public static String qtdeQuestoesTotalCertoFile = "qtdeQuestoesTotalCertoFile";
    public static int percentualAcertoTotalV = 0;

    static {
        questoesErradas = new ArrayList<>();
        user = new UsuarioDTO();
    }

    /*Portugues*/
    public static int acertoPTV = 0;
    public static String totalAcertosPT = "totalAcertosPT";
    public static int totalPT = 0;
    public static String totalQuestoesPT = "totalQuestoesPT";

    /*MATEMATICA*/
    public static String totalAcertosMTM = "totalAcertosMTM";
    public static int acertoMTMV = 0;
    public static String totalQuestoesMTM = "totalQuestoesMTM";
    public static int totalMTM = 0;

    /*INGLES*/
    public static String totalAcertosING = "totalAcertosING";
    public static int acertoING = 0;
    public static String totalQuestoesING = "totalQuestoesING";
    public static int totalING = 0;

    /*ESPANHOL*/
    public static String totalAcertosESP = "totalAcertosESP";
    public static int acertoESP = 0;
    public static String totalQuestoesESP = "totalQuestoesESP";
    public static int totalESP = 0;


    /*FISICA*/
    public static String totalAcertosFIS = "totalAcertosFIS";
    public static int acertoFIS = 0;
    public static String totalQuestoesFIS = "totalQuestoesFIS";
    public static int totalFIS = 0;

    /*QUIMICA*/
    public static String totalAcertosQMC = "totalAcertosQMC";
    public static int acertoQMC = 0;
    public static String totalQuestoesQMC = "totalQuestoesQMC";
    public static int totalQMC = 0;

    /*HISTORIA*/
    public static String totalAcertosHIST = "totalAcertosHIST";
    public static int acertoHIST = 0;
    public static String totalQuestoesHIST = "totalQuestoesHIST";
    public static int totalHIST = 0;

    /*GEOGRAFIA*/
    public static String totalAcertosGEO = "totalAcertosGEO";
    public static int acertoGEO = 0;
    public static String totalQuestoesGEO = "totalQuestoesGEO";
    public static int totalGEO = 0;

    /*BIOLOGIA*/
    public static String totalAcertosBIO = "totalAcertosBIO";
    public static int acertoBIO = 0;
    public static String totalQuestoesBIO = "totalQuestoesBIO";
    public static int totalBIO = 0;

}
