package com.hrznstudio.sandbox.api.client.screen;

import com.hrznstudio.sandbox.api.client.Client;
import com.hrznstudio.sandbox.api.util.Identity;

public interface IScreen {

    Identity getScreenId();

    void init(Client client, int width, int height);

    void draw(int mouseX, int mouseY, float partialTicks);
}