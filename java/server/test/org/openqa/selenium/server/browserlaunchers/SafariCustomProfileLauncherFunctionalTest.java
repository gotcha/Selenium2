/*
Copyright 2012 Selenium committers
Copyright 2012 Software Freedom Conservancy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/


package org.openqa.selenium.server.browserlaunchers;

import org.openqa.selenium.server.RemoteControlConfiguration;

/**
 * {@link SafariCustomProfileLauncher} integration test class.
 */
public class SafariCustomProfileLauncherFunctionalTest extends LauncherFunctionalTestCase {

  public void testLauncherWithDefaultConfiguration() throws Exception {
    launchBrowser(new SafariCustomProfileLauncher(BrowserOptions.newBrowserOptions(),
        new RemoteControlConfiguration(), "CUST", null));
  }

  public void testLauncherWithHonorSystemProxyEnabled() throws Exception {
    final RemoteControlConfiguration configuration;

    configuration = new RemoteControlConfiguration();
    configuration.setHonorSystemProxy(true);
    launchBrowser(new SafariCustomProfileLauncher(BrowserOptions.newBrowserOptions(),
        configuration, "CUST", null));
  }

  public void testLaunchTwoBrowsersInARowWithDefaultConfiguration() throws Exception {
    final RemoteControlConfiguration configuration = new RemoteControlConfiguration();

    launchBrowser(new SafariCustomProfileLauncher(BrowserOptions.newBrowserOptions(),
        configuration, "CUST", null));
    launchBrowser(new SafariCustomProfileLauncher(BrowserOptions.newBrowserOptions(),
        configuration, "CUST", null));
  }

}
