package com.sorted.lac.service.enums;


public enum TipologiaEnum {
    NENHUMA(0, "SEM TIPOLOGIA", "STP"),
    FAT1(1, "GERAL", "FAT"),
    MIN2(2, "EXTRAÇÃO DE MINERAIS ", "MIN"),
    FRU3(3, "ATIVIDADES AGROPECUÁRIAS E SILVICULTURAIS - FRU", "FRU"),
    VEG4(4, "EXTRAÇÃO VEGETAL", "VEG"),
    AQU5(5, "AQUICULTURA", "AQU"),
    IND6(6, "INDÚSTRIA DE PRODUTOS MINERAIS NÃO METÁLICOS", "IND"),
    IND7(7, "INDÚSTRIA METALÚRGICA", "IND"),
    IND8(8, "INDÚSTRIA MECÂNICA", "IND"),
    IND9(9, "INDÚSTRIA DE MATERIAL ELÉTRICO E COMUNICAÇÕES", "IND"),
    IND10(10, "INDÚSTRIA DE MATERIAL DE TRANSPORTE", "IND"),
    IND11(11, "INDÚSTRIA DA MADEIRA", "IND"),
    IND12(12, "INDÚSTRIA DE MOBILIÁRIO", "IND"),
    IND13(13, "INDÚSTRIA DE PAPEL E PAPELÃO", "IND"),
    IND14(14, "INDÚSTRIA DA BORRACHA", "IND"),
    IND15(15, "INDÚSTRIA DE COUROS E PELES E PRODUTOS SIMILARES", "IND"),
    IND16(16, "INDÚSTRIA QUÍMICA", "IND"),
    IND17(17, "INDÚSTRIA DE PRODUTOS FARMACÊUTICOS E  VETERINÁRIOS", "IND"),
    IND18(18, "INDÚSTRIA DO REFINO DE PETRÓLEO E DESTILAÇÃO DO  ÁLCOOL", "IND"),
    IND19(19, "INDÚSTRIA DE PRODUTOS DE MATÉRIAS PLÁSTICAS", "IND"),
    IND20(20, "INDÚSTRIA TÊXTIL", "IND"),
    IND21(21, "INDÚSTRIA DE VESTUÁRIO E ARTEFATOS TÊXTEIS", "IND"),
    IND22(22, "INDÚSTRIA DE PRODUTOS ALIMENTARES", "IND"),
    IND23(23, "INDÚSTRIA DE BEBIDAS E ÁLCOOL ETÍLICO", "IND"),
    IND24(24, "INDÚSTRIA DE FUMO", "IND"),
    IND25(25, "INDÚSTRIA EDITORIAL E GRÁFICA", "IND"),
    IND26(26, "INDÚSTRIAS DIVERSAS", "IND"),
    DIV27(27, "CONSTRUÇÃO CIVIL - DIV", "DIV"),
    DIV28(28, "SERVIÇOS DE INFRAESTRUTURA - DIV", "DIV"),
    PAB29(29, "COMÉRCIO VAREJISTA - PAB", "PAB"),
    DIV30(30, "COMÉRCIO ATACADISTA E DEPÓSITOS - DIV", "DIV"),
    DIV31(31, "TRANSPORTES E TERMINAIS - DIV", "DIV"),
    IND32(32, "SERVIÇOS DIVERSOS - IND", "IND"),
    HSP33(33, "SERVIÇOS MEDICO-HOSPITALAR, LABORATORIAL E  VETERINÁRIO", "HSP"),
    DIV34(34, "ADMINISTRAÇÃO PÚBLICA, DEFESA E SEGURANÇA", "DIV"),
    URB35(35, "ATIVIDADES DIVERSAS - URB", "URB"),
    ORI36(36, "ATIVIDADES AGROPECUÁRIAS E SILVICULTURAIS - ORI", "ORI"),
    AGD37(37, "ATIVIDADES AGROPECUÁRIAS E SILVICULTURAIS - AGD", "AGD"),
    SUI38(38, "ATIVIDADES AGROPECUÁRIAS E SILVICULTURAIS - SUI", "SUI"),
    DIV39(39, "ATIVIDADES AGROPECUÁRIAS E SILVICULTURAIS - DIV", "DIV"),
    NADA1(40, "SEM USO", "-"),
    SAN41(41, "CONSTRUÇÃO CIVIL - SAN", "SAN"),
    SAN42(42, "SERVIÇOS DE INFRAESTRUTURA - SAN", "SAN"),
    RSU43(43, "SERVIÇOS DE INFRAESTRUTURA - RSU", "RSU"),
    AGR44(44, "COMÉRCIO ATACADISTA E DEPÓSITOS - AGR", "AGR"),
    TPP45(45, "TRANSPORTES E TERMINAIS - TPP", "TPP"),
    NADA2(46, "SEM USO", "-"),
    TPP47(47, "SERVIÇOS DIVERSOS - TPP", "TPP"),
    DIV48(48, "SERVIÇOS DIVERSOS - DIV", "DIV"),
    AGR49(49, "SERVIÇOS DIVERSOS - AGR", "AGR"),
    RSI50(50, "ATIVIDADES DIVERSAS - RSI", "RSI"),
    DIV51(51, "ATIVIDADES DIVERSAS - DIV", "DIV"),
    REC52(52, "ATIVIDADES DIVERSAS - REC", "REC"),
    AGR53(53, "ATIVIDADES DIVERSAS - AGR", "AGR"),
    CRT54(54, "ATIVIDADE NÃO CONSTANTE DA RESOLUÇÃO CONSEMA 01/06", "CRT"),
    RPN55(55, "RESERVA PARTICULAR DO PATRIMÔNIO NATURAL ESTADUAL - RPPN", "RPN"),
    ALP56(56, "AREAS LEGALMENTE PROTEGIDAS","ALP"),
    FNA57(57, "CAPTURA, COLETA E TRANSPORTE DE FAUNA SILVESTRE","FNA"),
    LAB58(58, "LABORATORIOS","LAB"),
    REP59(59, "REPOSIÇÃO FLORESTAL","REP"),
    ARL60(60, "AVERBAÇÃO DE RESERVA LEGAL","ARL"),
    RVG61(61, "REPOSIÇÃO DE VEGETAÇÃO","RVG"),
    CAD62(62, "COMPENSAÇÃO DE ÁREA EM DOBRO", "CAD"),
    CRL63(63, "CADASTRO DE RESERVA LEGAL", "CRL");

    private int id;
    private String descricao;
    private String tipololigiaSigla;

    private TipologiaEnum(int id, String descricao, String tipololigiaSigla) {
        this.id = id;
        this.descricao = descricao;
        this.tipololigiaSigla = tipololigiaSigla;
    }

    public String getTipologiaSigla() {
        return tipololigiaSigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public static TipologiaEnum valueOf(int id){
        for(TipologiaEnum tipologia : TipologiaEnum.values()){
            if(tipologia.getId() == id){
                return tipologia;
            }
        }
        return NENHUMA;
    }

}
