package com.cotivit.distributedtracing.msfour.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientsAndPayers {
    private List<Client> clients;
    private List<Payer> payers;
}
