package com.example.mois_user.data_loader;

import com.example.mois_user.domain.Address;
import com.example.mois_user.domain.Role;
import com.example.mois_user.repository.AddressRepository;
import com.example.mois_user.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressLoader implements CommandLineRunner {

    private final AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {
        loadAddressData();
    }

    private void loadAddressData() {
        if (addressRepository.count() == 0) {
            Address address1 = new Address( 1l, "HK", "500 06", "Hradecka, 21");
            Address address2 = new Address(2l, "PCE", "235 12", "Nekde, 12");
            addressRepository.save(address1);
            addressRepository.save(address2);
        }
        System.out.println(addressRepository.count());
    }
}
