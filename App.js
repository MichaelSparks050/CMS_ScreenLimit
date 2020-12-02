import React from 'react';
import {createAppContainer, createSwitchNavigator} from 'react-navigation';
import {createStackNavigator} from 'react-navigation-stack';
import {createBottomTabNavigator} from 'react-navigation-tabs';

import MasterScreen from './src/screens/MasterScreen';
import LoginScreen from './src/screens/LoginScreen';
import NewUserScreen from './src/screens/NewUserScreen';
import NewProfileScreen from './src/screens/NewProfileScreen';
import TrialScreen from './src/screens/TrialScreen';
import UserScreen from './src/screens/UserScreen';
import HistoryScreen from './src/screens/HistoryScreen';
import SettingScreen from './src/screens/SettingScreen';
import AppPrepScreen from './src/screens/AppPrepScreen';
import ResolveAuthScreen from './src/screens/ResolveAuthScreen';
import AboutAppScreen from './src/screens/AboutAppScreen';
import { Provider as AuthProvider } from './src/context/AuthContext';
import {setNavigator} from './src/navigationRef'

import ToastExample from './android/app/src/main/java/com/secondtestproj/ToastExample';






const switchNavigator = createSwitchNavigator({
  Resolve: ResolveAuthScreen,
  loginFlow: createStackNavigator({
      Master: MasterScreen,
      Login: LoginScreen,
      NUser: NewUserScreen,
      Trial: TrialScreen,
      NProfile: NewProfileScreen,
      AboutApp: AboutAppScreen
    }),
    mainFlow: createStackNavigator({
      User: UserScreen,
      History: HistoryScreen,
      Setting: SettingScreen,
      Apps: AppPrepScreen,
    })
});

const App = createAppContainer(switchNavigator);
export default () => {
  return(
    <AuthProvider>
      <App ref = {(navigator) => {setNavigator(navigator);}} />
    </AuthProvider>
  );

  function getTrialResponse(argument)
  {
    if(argument == true)
    {
      ToastExample.printTrue();
    }
    else
    {
      ToastExample.printFalse();
    }
    
  }

};