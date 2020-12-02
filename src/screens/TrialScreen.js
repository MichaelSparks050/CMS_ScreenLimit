//Outside Imports
import React, {useState, useContext} from 'react';
import {View, StyleSheet, ScrollView, SafeAreaView} from 'react-native';
import {Text, Button} from 'react-native-elements';
import RNPickerSelect from 'react-native-picker-select';

//Local Imports
import {Context as AuthContext} from '../context/AuthContext';
import '../components/globals';

import ToastExample from '../../android/app/src/main/java/com/secondtestproj/ToastExample';

//This is a nice optional insentive for users to try out the most basic portion of our app and see if they want to continue with us.
const TrialScreen = ({navigation}) => {
    const{ state, trialSignUp} = useContext(AuthContext);
    const [timeParameters, setTimeParameters] = useState('');

    return (
        <SafeAreaView style={styles.mainContainer}>
            <Text h1 style={styles.mainTitle}>Trial </Text>

            <ScrollView style={styles.subContainer}>
                <Text style={styles.textDetail}>
                    Uncertain if you're a bit too attached to your phone?
                    Screen Limit's test trial can help with that.
                </Text>
                <Text style={styles.textDetail}>
                    The Screen Limit 'Test Trial' will only keep track of the amount of time you spend
                    on your apps for a set period of time. At the end of your trial run, we will then
                    display your activity in a handy graph!
                </Text>
                <Text style={styles.textDetail}>
                    If you feel the time you spend on apps is within acceptable bounds, then you can
                    continue with a clear conscious. However, if you discover that your app use is
                    a rather excessive, feel free to try out our app officially and employ our
                    methods to curb your attachment to your phone.
                </Text>
            </ScrollView>

            <View>
                <RNPickerSelect
                    style={styles.smallTextDetail}
                    placeholder={{label: "Select Time Here...", value: null}}
                    onValueChange={(value) => setTimeParameters(value)}
                    items={[
                        { label: '1 Day', value: '1 Day'},
                        { label: '1 Week', value: '1 Week' },
                        { label: '1 Month', value: '1 Month' },
                    ]}
                />
                <Button
                    title = '3Begin My Timed Trial3'
                    //onPress={() => trialSignUp({timeParameters})}      startTrialPeriod()
                    onPress={() => {ToastExample.startTrialPeriod()}}
                    buttonStyle={{ backgroundColor: '#4682b4' }}
                />
                <Button
                    title = "Return To Welcome Screen"
                    onPress={() => navigation.navigate('NUser')}
                    titleStyle = {styles.linkTextDetail}
                    type="clear"
                />
            </View>

        </SafeAreaView>

    );
};

TrialScreen.navigationOptions = () => {return { headerShown: false, }; };

const styles = StyleSheet.create({
    mainContainer: {
        flex: 1,
        borderWidth:10,
        backgroundColor: colorSecondary,
    },
    subContainer: {
        flex: 1,
        padding: 5,
        backgroundColor: 'black',
        marginBottom: 20
    },
    mainTitle:{
        color: colorWhite_1,
        fontSize: 25,  
        textAlign: 'center',
        fontWeight: "bold",
        fontStyle: "italic",
    },
    largeTextDetail: {
        marginTop: 20,
        marginBottom: 10,
        fontSize: 25,
        textAlign: 'center',
        fontFamily: headingFont,
        color: colorWhite_1
      },
      linkTextDetail:{
        color: '#add8e6',
        fontSize: 13,
        marginBottom: 20
    },
      textDetail: {
        fontSize: 20,
        marginLeft: 20,
        textAlign: 'left',
        fontFamily: subheadingFont,
        color: colorWhite_1
      },
});

export default TrialScreen;