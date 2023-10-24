package com._aux.backend.enums;

public enum AdminTitle {
    ADMIN_PRINCIPAL("Administrador Principal"),
    MODERADOR_CONTEUDO("Moderador de Conteúdo"),
    ADMIN_USUARIOS("Administrador de Usuários"),
    ADMIN_RELATORIOS("Administrador de Relatórios");

    private final String title;

    AdminTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
