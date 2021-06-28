package com.example.taresmobileapp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.taresmobileapp.helpers.CustomSpinnerAdapter;
import com.example.taresmobileapp.helpers.GlideApp;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ModifyProfilActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = ModifyProfilActivity.class.getSimpleName();
    public static final int REQUEST_IMAGE = 100;

    Toolbar toolbar;
    Spinner countriesSpinner;
    TextView btnSave, btnFingerprint;
    CustomSpinnerAdapter customSpinnerAdapter;
    ImageView backArrow, modifyImage, imgProfile;


    String [] countriesNames = {
            "Votre Pays", "Afghanistan", "Afrique du Sud", "Albanie", "Algérie", "Allemagne", "Angola", "Arabie Saoudite", "Argentine",
            "Arménie", "Aruba", "Australie", "Autriche", "Azerbaïjan", "Ïles Bahamas", "Bangladesh", "Belgique", "Bénin", "Birmanie",
            "Bolivie", "Bosnie", "Bostwana", "Brazil", "Bulgarie", "Burkina Faso", "Burundi", "Cambodge", "Cameroon", "Canada", "Cap Vert",
            "Centre Afrique", "Chili", "Chine", "Chypre", "Colombie", "Comores", "RD Congo", "Congo", "Corée du Nord", "Corée du Sud",
            "Costa Rica", "Côte d'Ivoire", "Croatie", "Cuba", "Danemark", "Djibouti", "Dominique", "Egypte", "Equateur", "Espagne",
            "Estonie", "Eswatini", "Etats-Unis", "Ethiopie", "Finland", "France", "Gabon", "Gambie", "Georgie", "Ghana", "Gibraltar",
            "Grèce", "Guatemala", "Guinée-Bisseau", "Guinée Equatoriale", "Guyana", "Haïti", "Honduras", "Hongrie", "India", "Indonésie",
            "Irak", "Iran", "Irlande", "Islande", "Israël", "Italie", "Jamaïque", "Japon", "Jordanie", "Kenya", "Kosovo", "Koweït",
            "Lesotho", "Lettonie", "Liban", "Libéria", "Lybie", "Lituanie", "Luxembourg", "Macao", "Madagascar", "Malasie", "Malawi",
            "Maldives", "Mali", "Maltes", "Maroc", "Martinique", "ïles Maurice", "Mauritanie", "Mexico", "Monténégro", "Mozambique",
            "Namibie", "Népal", "Niger", "Nigéria", "Norvège", "Nouvelle-Zélande", "Ouganda", "Pakistan", "Palestine", "Panama", "Paraguay",
            "Pays-Bas", "Pérou", "Philippines", "Pologne", "Porto-Rico", "Portugal", "Qatar", "Roumanie", "Royaume-Uni", "Russie", "Rwanda",
            "Salomon", "Salvador", "Samoa", "Sao-Tomé Principe", "Sénégal", "Serbie", "ïles Seychelles", "Sierra Leone", "Slovaquie",
            "Slovénie", "Somalie", "Soudan", "Suède", "Suisse", "Syrie", "Tanzanie", "Tchad", "République Tchèque", "Thaïlande", "Togo",
            "Tonga", "Tunisie", "Turkie", "Ukraine", "Uruguay", "Venezuela", "ViêtNam", "Yémen", "Zambie", "Zimbabwe",
    };

    String [] countriesCodes = {
            "(BJ +229)", "(AF +93)", "(ZA +27)", "(AL +355)", "(DZ +213)", "(DE +49)", "(AO +244)", "(SA +966)", "(AR +54)", "(AM +374)",
            "(AW +297)", "(AU +61)", "(AT +43)", "(AZ +994)", "(BS +1 242)", "(BD +880)", "(BE +32)", "(BJ +229)", "(BM +95)", "(BO +591)",
            "(BA +387)", "(BW +267)", "(BR +55)", "(BG +359)", "(BF +226)", "(BI +257)", "(KH +855)", "(CM +237)", "(CA +1)", "(CV +238)",
            "(CF +236)", "(CI +56)", "(CN +86)", "(CY +357)", "(CO +57)", "(KM +269)", "(CD +243)", "(CG +242)", "(KP +850)", "(KR +82)",
            "(CR +506)", "(CI +225)", "(HR +385)", "(CU +53)", "(DK +45)", "(DJ +253)", "(DM +1 767)", "(EG +20)", "(EC +593)", "(ES +34)",
            "(EE +372)", "(SZ +268)", "(US +1)", "(ET +251)", "(FI +358)", "(FR +33)", "(GA +241)", "(GM +220)", "(GE +995)", "(GH +233)",
            "(GI +350)", "(GR +30)", "(GT +502)", "(GW +245)", "(GQ +240)", "(GY +592)", "(HT +509)", "(HN +504)", "(HU +36)", "(IN +91)",
            "(ID +62)", "(IQ +964)", "(IR +98)", "(IE +353)", "(IS +354)", "(IL +972)", "(IT +39)", "(JM +1 876)", "(JP +81)", "(JO +962)",
            "(KE +254)", "(XK +383)", "(KW +965)", "(LS +266)", "(LV +371)", "(LB +961)", "(LR +231)", "LY +218)", "(LT +370)", "(LU +352)",
            "(MO +853)", "(MG +261)", "(MY +60)", "(MW +265)", "(MV +960)", "(ML +223)", "(MT +356)", "(MA +212)", "(MQ +596)", "(MU +230)",
            "(MR +222)", "(MX +52)", "(ME +382)", "(MZ +258)", "(NA +264)", "(NP +977)", "(NE +227)", "(NG +234)", "(NO +47)", "(NZ +64)",
            "(UG +256)", "(PK +92)", "(PS +970)", "(PA +507)", "(PY +595)", "(NL +31)", "(PE +51)", "(PH +63)", "(PL +48)", "(PR +1)",
            "(PT +351)", "(QA +974)", "(RO +40)", "(GB +44)", "(RU +7)", "(RW +250)", "(SB +677)", "(SV +503)", "(WS +685)", "(ST +239)",
            "(SN +221)", "(RS +381)", "(SC +248)", "(SL +232)", "(SK +421)", "(SI +386)", "(SO +252)", "(SD +249)", "(SE +46)", "(CH +41)",
            "(SY +963)", "(TZ +255)", "(TD +235)", "(CZ +420)", "(TH +66)", "(TG +228)", "(TO +676)", "(TN +216)", "(TR +90)", "(UA +380)",
            "(UY +598)", "(VE +58)", "(VN +84)", "(YE +967)", "(ZM +260)", "(ZW +263)",
    };

    String [] countriesPhonePrefixes = {
            "+229", "+93", "+27", "+355", "+213", "+49", "+244", "+966", "+54", "+374", "+297", "+61", "+43", "+994", "+1 242", "+880",
            "+32", "+229", "+95", "+591", "+387", "+267", "+55", "+359", "+226", "+257", "+855", "+237", "+1", "+238", "+236", "+56",
            "+86", "+357", "+57", "+269", "+243", "+242", "+850", "+82", "+506", "+225", "+385", "+53", "+45", "+253", "+1 767", "+20",
            "+593", "+34", "+372", "+268", "+1", "+251", "+358", "+33", "+241", "+220", "+995", "+233", "+350", "+30", "+502", "+245",
            "+240", "+592", "+509", "+504", "+36", "+91", "+62", "+964", "+98", "+353", "+354", "+972", "+39", "+1 876", "+81", "+962",
            "+254", "+383", "+965", "+266", "+371", "+961", "+231", "+218", "+370", "+352", "+853", "+261", "+60", "+265", "+960",
            "+223", "+356", "+212", "+596", "+230", "+222", "+52", "+382", "+258", "+264", "+977", "+227", "+234", "+47", "+64", "+256",
            "+92", "+970", "+507", "+595", "+31", "+51", "+63", "+48", "+1", "+351", "+974", "+40", "+44", "+7", "+250", "+677", "+503",
            "+685", "+239", "+221", "+381", "+248", "+232", "+421", "+386", "+252", "+249", "+46", "+41", "+963", "+255", "+235",
            "+420", "+66", "+228", "+676", "+216", "+90", "+380", "+598", "+58", "+84", "+967", "+260", "+263",
    };


    int [] countriesImages = {
            R.drawable.drap, R.drawable.afghan, R.drawable.sud_afrique, R.drawable.albania, R.drawable.algeria, R.drawable.allemand,
            R.drawable.angola, R.drawable.arabie_saoudia, R.drawable.argentine, R.drawable.armenia, R.drawable.aruba, R.drawable.australia,
            R.drawable.autriche, R.drawable.azerbaijan, R.drawable.bahamas, R.drawable.bangladesh, R.drawable.belge, R.drawable.benin,
            R.drawable.birmanie, R.drawable.bolivia, R.drawable.bosnia, R.drawable.bostwana, R.drawable.brazil, R.drawable.bulgare,
            R.drawable.burkina_faso, R.drawable.burundi, R.drawable.cambodge, R.drawable.cameroon, R.drawable.canada, R.drawable.cap_verde,
            R.drawable.centre_afrique, R.drawable.chilie, R.drawable.chine, R.drawable.chypre, R.drawable.colombia, R.drawable.comores,
            R.drawable.rdc, R.drawable.congo, R.drawable.nord_coree, R.drawable.sud_coree, R.drawable.costa_rica, R.drawable.cote_ivoire,
            R.drawable.croatia, R.drawable.cuba, R.drawable.danmark, R.drawable.djibouti, R.drawable.dominica, R.drawable.egypte,
            R.drawable.equator, R.drawable.espagne, R.drawable.estonia, R.drawable.eswatini, R.drawable.usa, R.drawable.ethiopia,
            R.drawable.finland, R.drawable.france, R.drawable.gabon, R.drawable.gambie, R.drawable.georgia, R.drawable.ghana,
            R.drawable.gibraltar, R.drawable.grec, R.drawable.guatemala, R.drawable.guinee_bisseau, R.drawable.guinee_equatorial,
            R.drawable.guyana, R.drawable.haiti, R.drawable.honduras, R.drawable.hongrie, R.drawable.india, R.drawable.indonesia,
            R.drawable.irak, R.drawable.iran, R.drawable.ireland, R.drawable.iseland, R.drawable.israel, R.drawable.italia,
            R.drawable.jamaica, R.drawable.japan, R.drawable.jordania, R.drawable.kenya, R.drawable.kosovo, R.drawable.kuwait,
            R.drawable.lesotho, R.drawable.lettonie, R.drawable.liban, R.drawable.liberia, R.drawable.libya, R.drawable.lituanie,
            R.drawable.luxembourg, R.drawable.macao, R.drawable.malgasch, R.drawable.malasya, R.drawable.malawi, R.drawable.maldives,
            R.drawable.mali, R.drawable.malta, R.drawable.maroc, R.drawable.martinique, R.drawable.maurice, R.drawable.maures,
            R.drawable.mexico, R.drawable.montenegro, R.drawable.mozambique, R.drawable.namibia, R.drawable.nepal, R.drawable.niger,
            R.drawable.nigeria, R.drawable.norvege, R.drawable.new_zelande, R.drawable.ouganda, R.drawable.pakistan, R.drawable.palestine,
            R.drawable.panama, R.drawable.paraguay, R.drawable.pays_bas, R.drawable.peru, R.drawable.philippines, R.drawable.pologne,
            R.drawable.porto_rico, R.drawable.portugal, R.drawable.qatar, R.drawable.romania, R.drawable.royaume_uni, R.drawable.russe,
            R.drawable.rwanda, R.drawable.salomon, R.drawable.salvador, R.drawable.samoa, R.drawable.saotome, R.drawable.senegal,
            R.drawable.serbia, R.drawable.seychelles, R.drawable.sierra_leonne, R.drawable.slovakia, R.drawable.slovenia, R.drawable.somalia,
            R.drawable.sudan, R.drawable.suede, R.drawable.suisse, R.drawable.syria, R.drawable.tanzania, R.drawable.tchad, R.drawable.tcheque,
            R.drawable.thailand, R.drawable.togo, R.drawable.tonga, R.drawable.tunisia, R.drawable.turkey, R.drawable.ukraine,
            R.drawable.uruguay, R.drawable.venezuela, R.drawable.vietnam, R.drawable.yemen, R.drawable.zambia, R.drawable.zimbabwe,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This method is used so that our activity can cover the entire screen.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        //This method is used so that our activity can cover the entire screen.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.app_color));
        }

        setContentView(R.layout.activity_modify_profil);

        // Add Toolbar and Action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).hide();

        // Image View values
        modifyImage = findViewById(R.id.modify_image);
        imgProfile = findViewById(R.id.profile_image);

        // Clearing older images from cache directory
        // call this once the bitmap(s) usage is over
        loadProfileDefault();
        ImagePickerActivity.clearCache(this);

        countriesSpinner = findViewById(R.id.countries_spinner);
        countriesSpinner.setOnItemSelectedListener(this);

        customSpinnerAdapter = new CustomSpinnerAdapter(
                getApplicationContext(), countriesImages, countriesCodes, countriesNames);
        countriesSpinner.setAdapter(customSpinnerAdapter);

        // Modify and change user profile image
        modifyImage.setOnClickListener(v -> onProfileImageClick());
        imgProfile.setOnClickListener(v -> onProfileImageClick());

        // Back Arrow Button values action
        backArrow = findViewById(R.id.arrow_back_icon);
        backArrow.setOnClickListener(v -> super.onBackPressed());

        // Fingerprint Button values action
        btnFingerprint = findViewById(R.id.btn_fingersprint);
        btnFingerprint.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), FingerprintLoginActivity.class);
            startActivity(i);
        });

        // Save Button values action
        btnSave = findViewById(R.id.save_button);
        btnSave.setOnClickListener(v -> {
            //
        });

    }


    private void loadProfile(String url) {
        ImageView profileImage = findViewById(R.id.profile_image);
        Log.d(TAG, "Image cache path: " + url);

        GlideApp.with(this).load(url)
                .into(profileImage);
        profileImage.setColorFilter(ContextCompat.getColor(this,
                android.R.color.transparent));
    }

    private void loadProfileDefault() {
        ImageView profileImage = findViewById(R.id.profile_image);

        GlideApp.with(this).load(R.drawable.girl)
                .into(profileImage);
        profileImage.setColorFilter(ContextCompat.getColor(this,
                android.R.color.transparent));
    }

    private void onProfileImageClick() {
        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {

                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {
                            showImagePickerOptions();
                        }

                        if (report.isAnyPermissionPermanentlyDenied()) {
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions,
                                                                   PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }


    private void showImagePickerOptions() { ImagePickerActivity.showImagePickerOptions(
            this, new ImagePickerActivity.PickerOptionListener() {

            @Override
            public void onTakeCameraSelected() {
                launchCameraIntent();
            }

            @Override
            public void onChooseGallerySelected() {
                launchGalleryIntent();
            }
        });
    }

    private void launchCameraIntent() { Intent intent = new Intent(
            ModifyProfilActivity.this, ImagePickerActivity.class);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_IMAGE_CAPTURE);

        // setting maximum bitmap width and height
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_WIDTH, 1000);
        intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_HEIGHT, 1000);
        intent.putExtra(ImagePickerActivity.INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT, true);

        startActivityForResult(intent, REQUEST_IMAGE);
    }

    private void launchGalleryIntent() { Intent intent = new Intent(
            ModifyProfilActivity.this, ImagePickerActivity.class);

        // setting aspect ratio
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
        intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
        intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
        intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_GALLERY_IMAGE);

        startActivityForResult(intent, REQUEST_IMAGE);
    }


    /**
     * Showing Alert Dialog with Settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     */
    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ModifyProfilActivity.this);

        builder.setTitle(getString(R.string.dialog_permission_title));
        builder.setMessage(getString(R.string.dialog_permission_message));
        builder.setPositiveButton(getString(R.string.go_to_settings), (dialog, which) -> {
            dialog.cancel();
            openSettings();
        });
        builder.setNegativeButton(getString(android.R.string.cancel), (dialog, which)
                -> dialog.cancel());

        builder.show();
    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);

        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(), "Pays sélectionné : " + countriesNames[position],
                Toast.LENGTH_LONG).show();

        ImageView countryDrap = findViewById(R.id.country_drap);
        TextView countryPhonePrefix = findViewById(R.id.phone_prefix);

        countryDrap.setImageResource(countriesImages[position]);
        countryPhonePrefix.setText(countriesPhonePrefixes[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {

                assert data != null;
                Uri uri = data.getParcelableExtra("path");

                try {
                    // You can update this bitmap to your server
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

                    // loading profile image from local cache
                    loadProfile(uri.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}