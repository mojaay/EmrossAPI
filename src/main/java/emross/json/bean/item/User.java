package emross.json.bean.item;

public class User {
	private int id;
	private String nick;
	private int nationid;
	private int level;
	private int money;
	private String guild;
	private int guildid;
	private int gpower;
	private int gflag;
	private int protection;
	private int p_end;
	private int status;
	private City[] city;
	private Integer[] conq;
	private String[] gift;
	private int pvp;

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getNick() {
		return nick;
	}

	public final void setNick(String nick) {
		this.nick = nick;
	}

	public final int getNationid() {
		return nationid;
	}

	public final void setNationid(int nationid) {
		this.nationid = nationid;
	}

	public final int getLevel() {
		return level;
	}

	public final void setLevel(int level) {
		this.level = level;
	}

	public final int getMoney() {
		return money;
	}

	public final void setMoney(int money) {
		this.money = money;
	}

	public final String getGuild() {
		return guild;
	}

	public final void setGuild(String guild) {
		this.guild = guild;
	}

	public final int getGuildid() {
		return guildid;
	}

	public final void setGuildid(int guildid) {
		this.guildid = guildid;
	}

	public final int getGpower() {
		return gpower;
	}

	public final void setGpower(int gpower) {
		this.gpower = gpower;
	}

	public final int getGflag() {
		return gflag;
	}

	public final void setGflag(int gflag) {
		this.gflag = gflag;
	}

	public final int getProtection() {
		return protection;
	}

	public final void setProtection(int protection) {
		this.protection = protection;
	}

	public final int getP_end() {
		return p_end;
	}

	public final void setP_end(int p_end) {
		this.p_end = p_end;
	}

	public final int getStatus() {
		return status;
	}

	public final void setStatus(int status) {
		this.status = status;
	}

	public final City[] getCity() {
		return city;
	}

	public final void setCity(City[] city) {
		this.city = city;
	}

	public final Integer[] getConq() {
		return conq;
	}

	public final void setConq(Integer[] conq) {
		this.conq = conq;
	}

	public final String[] getGift() {
		return gift;
	}

	public final void setGift(String[] gift) {
		this.gift = gift;
	}

	public final int getPvp() {
		return pvp;
	}

	public final void setPvp(int pvp) {
		this.pvp = pvp;
	}
}