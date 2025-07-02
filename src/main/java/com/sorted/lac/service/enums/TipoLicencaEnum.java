package com.sorted.lac.service.enums;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TipoLicencaEnum {

    NP(0, "Sem licença definida","NP"),
    LAP(1, "Licença Ambiental Prévia","LAP"),
    LAI(2, "Licença Ambiental de Instalação","LAI"),
    LAO(3, "Licença Ambiental de Operação","LAO"),
    AUA(4, "Autorização Ambiental","AuA"),
    LAPLAI(5, "Licença Ambiental Prévia com dispensa de Licença Ambiental de Instalação","LAP com LAI"),
    LAILAO(6, "",""),
    LAPLAILAO(7, "Trifásica: LAP + LAI + LAO","Trifásica"),
    RENLAO(8, "Renovação de Licença Ambiental de Operação","Ren LAO"),
    AMPLAP(9, "Ampliação de LAP","Amp LAP"),
    AMPLAI(10, "Ampliação de LAI","Amp LAI"),
    AMPLAO(11, "Ampliação de LAO","Amp LAO"),
    AMPLAPLAI(12, "",""),
    AMPLAPLAILAO(13, "",""),
    RENAUA(14, "Renovação de Autorização Ambiental","Ren AuA"),
    RENLAI(15, "Renovação de Licença Ambiental de Instalação","Ren LAI"),
    AMPLAILAO(16, "",""),
    LAOCORRETIVA(17, "Licença Ambiental de Operação Corretiva","LAO Corretiva"),
    EXPLORACAO_FLORESTAL(18, "Autorização de Corte","AuC"),
    CONFAMBIENTAL(19, "Certidão de Conformidade Ambiental", 34,"Conf. Ambiental"),
    FAUNA(20, "Autorização Ambiental para Fauna","AuA para Fauna"),
    LABORATORIO(21, "Certidão de Reconhecimento de Laboratório","Cert. Laboratório"),
    REPOSICAO(22, "",""),
    MANIFESTACAO(23, "Manifestação do IMA","Manifestação"),
    LAC(24,"Licença Ambiental por Adesão e Compromisso","LAC"),
    RENLAC(25,"Licença Ambiental por Adesão e Compromisso(Substituição de Ren. LAO)","LAC (p/ Ren. LAO)"),
    RENLAOAUTODECLARATORIA(26,"Renovação LAO Autodeclaratória","Ren. LAO Auto"),
    LACRENLAO(27,"Renovação de Licença Ambiental por Adesão e Compromisso","Ren. LAC"),
    ANUENCIARIOSPUB(28,"Certidão de Anuência para Alteração de Registro de Imóveis","Certidão de Anuência"),
    ATIVIDADE_NAO_CONSTANTE(29, "Declaração de Atividade Não Constante da Resolução CONSEMA", 0,"DANC"),
    AUAC(30, "Autorização Ambiental por Adesão e Compromisso", "AuAC"),
    RENAUAAUT(31, "Renovação de Autorização Ambiental por Adesão Automática", "Ren. AUA Aut."),
    RENLAOAUT(32, "Renovação de Licença Ambiental de Operação Automática", "Ren. LAO Aut."),
    CAD(33, "Compensação de Área em Dobro", "CAD");

    public static List<TipoLicencaEnum> LICENCIAMENTO = new ArrayList<TipoLicencaEnum>();
    public static List<TipoLicencaEnum> CERTIDAO = new ArrayList<TipoLicencaEnum>();
    public static List<TipoLicencaEnum> EXPLORACAO = new ArrayList<TipoLicencaEnum>();
    public static List<TipoLicencaEnum> AMPLIACAO = new ArrayList<TipoLicencaEnum>();
    public static List<TipoLicencaEnum> VALORESTIMADO = new ArrayList<TipoLicencaEnum>();
    public static List<TipoLicencaEnum> EMPREGOSDIRETOSINDDIRETOS = new ArrayList<TipoLicencaEnum>();

    static {
        CERTIDAO.add(CONFAMBIENTAL);
        CERTIDAO.add(AUA);
        CERTIDAO.add(RENAUA);
        CERTIDAO.add(FAUNA);
        EXPLORACAO.add(REPOSICAO);
        EXPLORACAO.add(EXPLORACAO_FLORESTAL);
        for(TipoLicencaEnum v : TipoLicencaEnum.values()) {
            if(!CERTIDAO.contains(v) && !EXPLORACAO.contains(v)) {
                LICENCIAMENTO.add(v);
            }
        }
        AMPLIACAO.add(AMPLAP);
        AMPLIACAO.add(AMPLAI);
        AMPLIACAO.add(AMPLAO);
        AMPLIACAO.add(AMPLAPLAI);

        VALORESTIMADO.add(LAP);
        VALORESTIMADO.add(LAI);
        VALORESTIMADO.add(LAO);
        VALORESTIMADO.add(LAPLAI);
        VALORESTIMADO.add(LAILAO);
        VALORESTIMADO.add(LAPLAILAO);
        VALORESTIMADO.add(RENLAO);
        VALORESTIMADO.add(AMPLAP);
        VALORESTIMADO.add(AMPLAI);
        VALORESTIMADO.add(AMPLAO);
        VALORESTIMADO.add(AMPLAPLAI);
        VALORESTIMADO.add(AMPLAPLAILAO);
        VALORESTIMADO.add(RENLAI);
        VALORESTIMADO.add(AMPLAILAO);
        VALORESTIMADO.add(LAOCORRETIVA);

        EMPREGOSDIRETOSINDDIRETOS.add(LAP);
        EMPREGOSDIRETOSINDDIRETOS.add(LAI);
        EMPREGOSDIRETOSINDDIRETOS.add(LAO);
        EMPREGOSDIRETOSINDDIRETOS.add(LAPLAI);
        EMPREGOSDIRETOSINDDIRETOS.add(LAILAO);
        EMPREGOSDIRETOSINDDIRETOS.add(LAPLAILAO);
        EMPREGOSDIRETOSINDDIRETOS.add(RENLAO);
        EMPREGOSDIRETOSINDDIRETOS.add(AMPLAP);
        EMPREGOSDIRETOSINDDIRETOS.add(AMPLAI);
        EMPREGOSDIRETOSINDDIRETOS.add(AMPLAO);
        EMPREGOSDIRETOSINDDIRETOS.add(AMPLAPLAI);
        EMPREGOSDIRETOSINDDIRETOS.add(AMPLAPLAILAO);
        EMPREGOSDIRETOSINDDIRETOS.add(RENLAI);
        EMPREGOSDIRETOSINDDIRETOS.add(AMPLAILAO);
        EMPREGOSDIRETOSINDDIRETOS.add(LAOCORRETIVA);

    }

    public static Map<TipoLicencaEnum,TipoLicencaEnum> RENOVACOES = new HashMap<TipoLicencaEnum,TipoLicencaEnum>();
    public static Map<TipoLicencaEnum,TipoLicencaEnum> AMPLIACOES = new HashMap<TipoLicencaEnum,TipoLicencaEnum>();
    public static Map<TipoLicencaEnum,TipoLicencaEnum> SAIDAS = new HashMap<TipoLicencaEnum,TipoLicencaEnum>();
    public static Map<TipoLicencaEnum,TipoLicencaEnum> NAOUSADAS = new HashMap<TipoLicencaEnum,TipoLicencaEnum>();

    static{
        RENOVACOES.put(AUA, RENAUA);
        RENOVACOES.put(LAI, RENLAI);
        RENOVACOES.put(LAO, RENLAO);
        RENOVACOES.put(LAO, RENLAC);
        AMPLIACOES.put(LAP, AMPLAP);
        AMPLIACOES.put(LAI, AMPLAI);
        AMPLIACOES.put(LAO, AMPLAO);
        AMPLIACOES.put(LAPLAI, AMPLAPLAI);
        AMPLIACOES.put(LAPLAILAO, AMPLAPLAILAO);
        AMPLIACOES.put(LAILAO, AMPLAILAO);
        SAIDAS.put(LAP, LAP);
        SAIDAS.put(LAI, LAI);
        SAIDAS.put(LAO, LAO);
        SAIDAS.put(AUA, AUA);
        SAIDAS.put(RENAUA, AUA);
        SAIDAS.put(LAPLAI, LAI);
        SAIDAS.put(LAILAO, LAO);
        SAIDAS.put(LAPLAILAO, LAO);
        SAIDAS.put(RENLAO, LAO);
        SAIDAS.put(AMPLAP, LAP);
        SAIDAS.put(AMPLAI, LAI);
        SAIDAS.put(AMPLAO, LAO);
        SAIDAS.put(AMPLAPLAI, LAI);
        SAIDAS.put(AMPLAPLAILAO, LAO);
        SAIDAS.put(RENLAI, LAI);
        SAIDAS.put(AMPLAILAO, LAO);
        SAIDAS.put(LAOCORRETIVA, LAO);
        SAIDAS.put(EXPLORACAO_FLORESTAL, EXPLORACAO_FLORESTAL);
        SAIDAS.put(CONFAMBIENTAL, CONFAMBIENTAL);
        SAIDAS.put(ATIVIDADE_NAO_CONSTANTE, ATIVIDADE_NAO_CONSTANTE);
        NAOUSADAS.put(NP, NP);
        NAOUSADAS.put(EXPLORACAO_FLORESTAL,EXPLORACAO_FLORESTAL);
        NAOUSADAS.put(AMPLAPLAILAO, AMPLAPLAILAO);
        NAOUSADAS.put(REPOSICAO, REPOSICAO);
        NAOUSADAS.put(LABORATORIO, LABORATORIO);
        NAOUSADAS.put(FAUNA, FAUNA);
        NAOUSADAS.put(LAPLAILAO, LAPLAILAO);
        NAOUSADAS.put(LAILAO, LAILAO);
        NAOUSADAS.put(MANIFESTACAO, MANIFESTACAO);
        NAOUSADAS.put(AMPLAILAO, AMPLAILAO);
        NAOUSADAS.put(AMPLAPLAI, AMPLAPLAI);

    }

    private Integer valor;
    private String descricao;
    private Integer modeloin;
    private String sigla;

    TipoLicencaEnum(Integer valor,String descricao,Integer in, String sigla) {
        this.valor = valor;
        this.descricao = descricao;
        this.modeloin = in;
        this.sigla = sigla;
    }

    TipoLicencaEnum(Integer valor,String descricao, String sigla) {
        this(valor,descricao,-1, sigla);
    }

    /**
     * Retorna o TipoLicencaEnum de acordo com o id passado. Se não encontrar, retorna NP
     * @param id
     * @return
     */
    public static TipoLicencaEnum valueOf(int id){
        for(TipoLicencaEnum e : TipoLicencaEnum.values()){
            if(e.ordinal() == id){
                return e;
            }
        }
        return NP;
    }

    public String descricao(){
        return this.descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public Integer modeloin() {
        return modeloin;
    }

    public String sigla(){
        return this.sigla;
    }

    public String descricaoCompleta(){
        return this.sigla + " - " + this.descricao;
    }
}
