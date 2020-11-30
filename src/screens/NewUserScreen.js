//Outside Imports
import React from 'react';
import {View, StyleSheet, ScrollView, SafeAreaView} from 'react-native';
import {Text, Button} from 'react-native-elements';

//Local Imports
import '../components/globals';

const NewUserScreen = ({navigation}) => {
  return (
    <SafeAreaView style={styles.mainContainer}>
      <Text h1 style={styles.mainTitle}>Welcome To Screen Limit!</Text>
      <View style={styles.buttonOContainer}>
        <Button
            title = 'Click here to learn more'
            onPress={() => navigation.navigate('AboutApp')}
            titleStyle = {styles.linkTextDetail}
            buttonStyle={{ backgroundColor: 'black' }}
          />
      </View>
      <ScrollView style={styles.subContainer}>
        <Text style={styles.smallTextDetail}>New User?</Text>
        <Text style={styles.smallTextDetail}>Click below to get started</Text>
        <View style={styles.buttonIContainer}>
          <Button
            title = 'Create A New Profile'
            onPress = {() => navigation.navigate('NProfile')}
            buttonStyle={{ backgroundColor: '#4682b4'}}
          />
        </View>

        <Text style={styles.smallTextDetail}> Unsure you need our App? </Text>
        <View style={styles.buttonIContainer}>
          <Button
            title = 'Take Our Trial'
            onPress = {() => navigation.navigate('Trial')}
            buttonStyle={{ backgroundColor: '#4682b4' }}
          />
        </View>
      </ScrollView>

      <View>
          <Text style={styles.linkTextDetail}> Returning User ? </Text>
          <Button
            title = "Login Here!"
            onPress={() => navigation.navigate('Login')}
            titleStyle = {styles.linkTextDetail}
            type="clear"
          />
      </View>
    </SafeAreaView>
    );
};

NewUserScreen.navigationOptions = () => { return { headerShown: false, }; };

const styles = StyleSheet.create({
  mainContainer: {
    flex: 1,
    borderWidth:10,
    backgroundColor: colorSecondary,
  },
  subContainer:{
    flex: 1,
    padding: 20,
    backgroundColor: 'black',
  },
  buttonIContainer:{
    padding: 10,
    marginLeft: 15,
    marginRight: 15,
    marginBottom: 90
  },
  buttonOContainer:{
    marginLeft: 25,
    marginRight: 25,
    marginBottom: 5,
    padding:1
  },
  mainTitle:{
    color: colorWhite_1,
    fontSize: 35,  
    textAlign: 'center',
    fontWeight: "bold",
    fontStyle: "italic",
  },
  smallTextDetail: {
    fontSize: 18,
    textAlign: 'center',
    fontWeight: "bold",
    color: 'white'
  },
  linkTextDetail:{
    fontSize: 18,
    textAlign: 'center',
    color: '#add8e6',
  },

});

export default NewUserScreen;