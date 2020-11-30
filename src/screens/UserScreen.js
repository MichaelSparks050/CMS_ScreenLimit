//Outside Imports
import React, {useContext} from 'react';
import {View, StyleSheet, ScrollView, SafeAreaView} from 'react-native';
import {Text, Button} from 'react-native-elements';
import {Context as AuthContext} from '../context/AuthContext';

//Local Imports
import Exit from '../components/Exit';
import '../components/globals';
import { State } from 'react-native-gesture-handler';

//This is the default scene once the user has signed in & has apps in watch.
const UserScreen = ({navigation}) => {

    // User data passed from Login Screen
    var user = {};
    
    // My Own Hacked Together State Manager
    if(navigation.getParam('user')){
      user = navigation.getParam('user')
    } else {
      navigation.navigate('Login');
    }

    const {signout} = useContext(AuthContext);

    return (
      <SafeAreaView style={styles.mainContainer}>
        <Text h1 style={styles.mainTitle}>Screen Limit</Text>
        <Text style={styles.largeTextDetail}>Hello, {user.username}</Text>
        <Text style={styles.smallTextDetail}>Your method is {user.method}.</Text>

        <ScrollView style={styles.subContainer}>
          <View style={styles.buttonIContainer}>
            <Button
              title = 'View My History'
              onPress = {() => navigation.navigate('History', {username: user.username, userId: user._id})}
              buttonStyle={{ backgroundColor: '#4682b4', borderRadius: 20 }}
            />
          </View>

          <View style={styles.buttonIContainer}>
            <Button
              title = 'Change My Settings'
              onPress = {() => navigation.navigate('Setting')}
              buttonStyle={{ backgroundColor: '#4682b4', borderRadius: 20  }}
            />
          </View>
        </ScrollView>

        <View style={styles.buttonOContainer}>
          <Button
            title = 'Sign Out'
            onPress={signout}
            buttonStyle={{ backgroundColor: '#4682b4' }}
          />
        </View>

        <Exit />
        
      </SafeAreaView>
    );
};

UserScreen.navigationOptions = () => { return { headerShown: false,  }; };

const styles = StyleSheet.create({
  mainContainer: {
    flex: 1,
    borderWidth:10,
    backgroundColor: colorSecondary,
  },
  subContainer: {
    flex: 1,
    padding: 20,
    backgroundColor: 'black',
  },
  buttonIContainer:{
    padding: 20,
    marginLeft: 15,
    marginRight: 15,
  },
  buttonOContainer:{
    marginLeft: 25,
    marginRight: 25,
    marginBottom: 5,
    padding:10,
  },
  mainTitle:{
    color: colorWhite_1,
    textAlign: 'center',
    fontWeight: "bold",
    fontStyle: "italic",
  },
  largeTextDetail: {
    color: colorWhite_1,
    marginBottom: 5,
    fontSize: 20,
    textAlign: 'center',
    fontWeight: "bold",
    fontStyle: "italic",
  },
  smallTextDetail: {
    color: colorWhite_1,
    fontSize: 14,
    textAlign: 'right',
    fontWeight: "bold",
    marginLeft: 20,
    marginRight: 20,
},

});

export default UserScreen;